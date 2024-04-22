package com.example.chess_statistics.model;

public class TypeBlitz {
    private Integer id;
    private Integer point;
    private Integer rank;
    private Integer win;
    private Integer lost;

    private  TypeBlitz(){

    }
    public TypeBlitz(Integer id, Integer point, Integer rank, Integer win, Integer lost) {
        this.id = id;
        this.point = point;
        this.rank = rank;
        this.win = win;
        this.lost = lost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }
}
