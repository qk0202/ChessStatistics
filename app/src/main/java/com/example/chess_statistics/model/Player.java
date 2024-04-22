package com.example.chess_statistics.model;

public class Player {
    private int id;
    private String name;
    private int point;

    private String avatar;

    private String flag;
    private int rank;
    private int win;
    private int lost;

    private int point_classical;

    private int point_corr;

    private int point_blitz;

    public Player() {
    }

    // Constructor
    public Player(int id, String name, int point, String avatar, String flag, int rank, int win, int lost) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.avatar = avatar;
        this.flag = flag;
        this.rank = rank;
        this.win = win;
        this.lost = lost;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getPoint_classical() {
        return point_classical;
    }

    public void setPoint_classical(int point_classical) {
        this.point_classical = point_classical;
    }

    public int getPoint_corr() {
        return point_corr;
    }

    public void setPoint_corr(int point_corr) {
        this.point_corr = point_corr;
    }

    public int getPoint_blitz() {
        return point_blitz;
    }

    public void setPoint_blitz(int point_blitz) {
        this.point_blitz = point_blitz;
    }
}
