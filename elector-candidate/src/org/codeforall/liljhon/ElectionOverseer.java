package org.codeforall.liljhon;

import java.util.*;
import java.util.stream.Collectors;

public class ElectionOverseer {

    private Set<Voter> voters;

    private Map<String, Jedi> jedis;

    public ElectionOverseer(Set<Voter> voters, Map<String, Jedi> jedis) {
        this.voters = voters;
        this.jedis = jedis;
    }

    private void votePhase() {
        for (Voter voter : voters) {

            if (voter.isFraudulent()) continue;

            jedis.get(voter.getVotedJedi()).votedOn();

        }
    }

    public List<Jedi> topJedis() {

        votePhase();

        return jedis.values().stream()
                .sorted((e , n) -> n.getVotes() - e.getVotes())
                .limit(3)
                .collect(Collectors.toList());

    }


}
