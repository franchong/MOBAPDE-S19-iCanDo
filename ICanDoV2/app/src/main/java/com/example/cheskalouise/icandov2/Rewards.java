package com.example.cheskalouise.icandov2;

/**
 * Created by CheskaLouise on 11/15/2017.
 */

public class Rewards {
    String title;
    String description;
    String recurring;
    int points;

    public Rewards(String title, String description, String recurring, int points) {
        this.title = title;
        this.description = description;
        this.recurring = recurring;
        this.points = points;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecurring() {
        return recurring;
    }

    public void setRecurring(String recurring) {
        this.recurring = recurring;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
