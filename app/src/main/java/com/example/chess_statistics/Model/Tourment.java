package com.example.chess_statistics.Model;

public class Tourment {
    private int id;
    private String nameTour;
    private String ipTour;
    private String avtTour;

    public Tourment() {
    }

    public Tourment(int id, String nameTour, String ipTour, String avtTour) {
        this.id = id;
        this.nameTour = nameTour;
        this.ipTour = ipTour;
        this.avtTour = avtTour;
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

    public String getAvtTour() {
        return avtTour;
    }

    public void setAvtTour(String avtTour) {
        this.avtTour = avtTour;
    }
}
