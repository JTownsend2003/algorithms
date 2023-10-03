package org.codeforall.liljhon;

public class Jedi {

    private int votes;
    private String name;

    public Jedi(String name) {
        this.name = name;
        votes = 0;
    }

    public void votedOn() {
        votes++;
    }

    public int getVotes() {
        return votes;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Jedi)) {
            return false;
        }

        return this.name.equals(((Jedi)obj).name);
    }

    @Override
    public String toString() {
        return name + " " + votes + " votes!";
    }
}
