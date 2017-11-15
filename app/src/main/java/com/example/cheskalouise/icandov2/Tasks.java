package com.example.cheskalouise.icandov2;

/**
 * Created by CheskaLouise on 11/15/2017.
 */

public class Tasks {

    private String title;
    private String description;
    private String dueDate;
    private String day;
    private String recurring;

    public Tasks(String title, String description, String dueDate, String day, String recurring) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.day = day;
        this.recurring = recurring;
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRecurring() {
        return recurring;
    }

    public void setRecurring(String recurring) {
        this.recurring = recurring;
    }
}
