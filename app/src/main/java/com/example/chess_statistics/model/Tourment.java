package com.example.chess_statistics.model;

public class Tourment {
    private int tour_id;
    private String nameTour;
    private String ipTour;
    private String avtTour;

    public Tourment() {
    }

    public Tourment(int id, String nameTour, String ipTour, String avtTour) {
        this.tour_id = tour_id;
        this.nameTour = nameTour;
        this.ipTour = ipTour;
        this.avtTour = avtTour;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
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
