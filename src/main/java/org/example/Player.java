package org.example;

public class Player {
    private String name;
    private int wins;
    private int losses;

    public Player(String name){
        this.name = name;
        this.losses=0;
        this.wins=0;
    }
}
