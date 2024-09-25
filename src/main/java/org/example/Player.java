package org.example;

public class Player {
    public String name;
    public int wins;
    public int losses;

    public Player(String name){
        this.name = name;
        this.losses=0;
        this.wins=0;
    }
}
