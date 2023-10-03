package org.codeforall.liljhon;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AntiFraudComputer {

    private BufferedReader reader;

    private Set<Voter> voters;

    private Map<String, Jedi> jedis;



    public AntiFraudComputer() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader("resources/election.txt"));
        voters = new HashSet<>();
        jedis = new HashMap<>();
        readVotes();
    }

    private void readVotes() {

        try {

            String line;

            while ((line = reader.readLine()) != null) {
                line = line.substring(1,line.length() - 1);
                String[] vote = line.split(",");

                Voter voter = new Voter(vote[0],vote[1]);

                if (!jedis.containsKey(vote[1])) {
                    jedis.put(vote[1], new Jedi(vote[1]));
                }

                if (voters.contains(voter)) {
                    voters.remove(voter);
                    voter.setFraudulent();
                }

                voters.add(voter);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Could not read file! Fraud Control aborted the election!");
            System.exit(1);
        }
    }

    public Set<Voter> getVoters() {
        return voters;
    }

    public Map<String, Jedi> getJedis() {
        return jedis;
    }
}
