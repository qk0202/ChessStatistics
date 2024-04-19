package com.example.chess_statistics.Model;

public class Player {
    private int id;
    private String name;
    private int point;
    private String pref;

    // Constructor
    public Player() {
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {return point;}

    public void getPoint(int score) {
        this.point = point;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public void setPoint(int anInt) {
    }
}
