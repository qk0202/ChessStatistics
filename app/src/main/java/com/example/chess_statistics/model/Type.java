package com.example.chess_statistics.model;

import java.util.ArrayList;

public class Type {

    private Integer id;
    private String name;
    private ArrayList<Player> players;

    public  Type(){}
    public Type(Integer id, String name, ArrayList<Player> players) {
        this.id = id;
        this.name = name;
        this.players = players;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
