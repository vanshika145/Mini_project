package com.example.mini_project;

public class Complaint {
    private String title;
    private String category;
    private String status;
    private String date;

    public Complaint(String title, String category, String status, String date) {
        this.title = title;
        this.category = category;
        this.status = status;
        this.date = date;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
    public String getDate() { return date; }
}
