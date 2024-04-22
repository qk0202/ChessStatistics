package com.example.chess_statistics.model;


public class Round {
    private int id;
    private String name_round;
    private String startDate;

    private String endDate;

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


    public int getTour_id() {
        return tour_id;
    }

    public void setTour_id(int tour_id) {
        this.tour_id = tour_id;
    }

    public String getName_round() {
        return name_round;
    }

    public void setName_round(String name_round) {
        this.name_round = name_round;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
