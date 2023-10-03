package org.codeforall.liljhon;

import java.io.FileNotFoundException;
import java.util.List;

public class Sandbox {

    public static void main(String[] args) {
        try {
            AntiFraudComputer reader = new AntiFraudComputer();
            ElectionOverseer overseer = new ElectionOverseer(reader.getVoters(), reader.getJedis());

            List<Jedi> topVotedJedis = overseer.topJedis();

            topVotedJedis.forEach(System.out::println);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        }
    }
}
