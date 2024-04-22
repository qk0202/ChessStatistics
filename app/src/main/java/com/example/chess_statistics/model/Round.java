package com.example.chess_statistics.model;


public class Round {
    private int id;
    private String name_round;
    private String date;

    private int tour_id;

    public Round() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_Round() {
        return name_round;
    }

    public void setName_Round(String name_Round) {
        this.name_round = name_round;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }
}
