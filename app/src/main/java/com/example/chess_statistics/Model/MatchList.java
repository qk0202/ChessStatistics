package com.example.chess_statistics.Model;

public class MatchList {
    private int id;
    private String player1;
    private String getPlayer2;
    private Byte[] flag1;
    private Byte[] flag2;
    private String result;

    public MatchList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getGetPlayer2() {
        return getPlayer2;
    }

    public void setGetPlayer2(String getPlayer2) {
        this.getPlayer2 = getPlayer2;
    }

    public Byte[] getFlag1() {
        return flag1;
    }

    public void setFlag1(Byte[] flag1) {
        this.flag1 = flag1;
    }

    public Byte[] getFlag2() {
        return flag2;
    }

    public void setFlag2(Byte[] flag2) {
        this.flag2 = flag2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
