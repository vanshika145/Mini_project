package com.example.mini_project;

public class Complaint {
    private String id;
    private String title;
    private String description;
    private String category;
    private String status; // "Pending", "Resolved", "Rejected"
    private String studentName;
    private String date;

    public Complaint(String id, String title, String description, String category, String studentName, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.studentName = studentName;
        this.date = date;
        this.status = "Pending";
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDate() {
        return date;
    }
}
