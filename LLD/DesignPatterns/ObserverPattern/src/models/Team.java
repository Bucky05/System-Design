package models;

import java.util.List;

public class Team {

    private String name;
    private String teamId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Player> players;
}
