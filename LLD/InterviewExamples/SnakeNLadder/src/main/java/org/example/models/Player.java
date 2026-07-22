package org.example.models;

public class Player {
    // id can be UUID but for interview purpose taking serial no. in mysql
    int id ;
    String name;
    Cell position;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        position = new Cell(0,-1);
    }
}
