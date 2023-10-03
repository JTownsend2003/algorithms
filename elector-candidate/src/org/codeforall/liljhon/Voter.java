package org.codeforall.liljhon;


public class Voter {

    private String name;

    private String votedJedi;

    private boolean fraudulent;


    public Voter(String name, String votedJedi) {
        this.name = name;
        this.votedJedi = votedJedi;
        fraudulent = false;
    }

    public String getName() {
        return name;
    }

    public String getVotedJedi() {
        return votedJedi;
    }

    public boolean isFraudulent() {
        return fraudulent;
    }

    public void setFraudulent() {
        this.fraudulent = true;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Voter voter)) {
            return false;
        }

        return name.equals(voter.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name + " I voted on " + votedJedi;
    }
}
