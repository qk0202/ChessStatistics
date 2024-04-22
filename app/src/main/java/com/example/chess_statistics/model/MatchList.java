package com.example.chess_statistics.model;

public class MatchList {
    private int matchlist_id;
    private int player1_id;
    private int player2_id;
    private int flag1_id;
    private int flag2_id;
    private int result1;
    private int result2;
    private int round_id;

    public MatchList() {
    }

    public int getMatchlist_id() {
        return matchlist_id;
    }

    public void setMatchlist_id(int matchlist_id) {
        this.matchlist_id = matchlist_id;
    }

    public int getPlayer1_id() {
        return player1_id;
    }

    public void setPlayer1_id(int player1_id) {
        this.player1_id = player1_id;
    }

    public int getPlayer2_id() {
        return player2_id;
    }

    public void setPlayer2_id(int player2_id) {
        this.player2_id = player2_id;
    }

    public int getFlag1_id() {
        return flag1_id;
    }

    public void setFlag1_id(int flag1_id) {
        this.flag1_id = flag1_id;
    }

    public int getFlag2_id() {
        return flag2_id;
    }

    public void setFlag2_id(int flag2_id) {
        this.flag2_id = flag2_id;
    }

    public int getResult1() {
        return result1;
    }

    public void setResult1(int result1) {
        this.result1 = result1;
    }

    public int getResult2() {
        return result2;
    }

    public void setResult2(int result2) {
        this.result2 = result2;
    }

    public int getRound_id() {
        return round_id;
    }

    public void setRound_id(int round_id) {
        this.round_id = round_id;
    }
}
