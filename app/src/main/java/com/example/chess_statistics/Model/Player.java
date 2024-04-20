package com.example.chess_statistics.Model;

public class Player {
    private int id;
    private String name;
    private int point;

    private String avatar;

    private String flag;
    private TypeBlitz typeBlitz;

    private TypeCorr typeCorr;
    private TypeClassical typeClassical;
    private int rank;
    private int win;
    private int lost;

    public  Player(){}
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

    public TypeBlitz getTypeBlitz() {
        return typeBlitz;
    }

    public void setTypeBlitz(TypeBlitz typeBlitz) {
        this.typeBlitz = typeBlitz;
    }

    public TypeCorr getTypeCorr() {
        return typeCorr;
    }

    public void setTypeCorr(TypeCorr typeCorr) {
        this.typeCorr = typeCorr;
    }

    public TypeClassical getTypeClassical() {
        return typeClassical;
    }

    public void setTypeClassical(TypeClassical typeClassical) {
        this.typeClassical = typeClassical;
    }
}
