package com.example.chess_statistics.Model;

public class Tourment {
    private int id;
    private String nameTour;
    private String ipTour;
    private byte[] avtTour;

    public Tourment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public String getIpTour() {
        return ipTour;
    }

    public void setIpTour(String ipTour) {
        this.ipTour = ipTour;
    }

    public byte[] getAvtTour() {
        return avtTour;
    }

    public void setAvtTour(byte[] avtTour) {
        this.avtTour = avtTour;
    }
}
