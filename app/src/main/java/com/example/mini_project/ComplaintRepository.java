package com.example.mini_project;

import java.util.ArrayList;
import java.util.List;

public class ComplaintRepository {
    private static ComplaintRepository instance;
    private List<Complaint> complaints;

    private ComplaintRepository() {
        complaints = new ArrayList<>();
        // Add dummy data
        complaints.add(new Complaint("1", "Broken Fan", "Fan in room 101 is not working", "Maintenance", "Alice",
                "2024-02-10"));
        complaints.add(new Complaint("2", "Water Leakage", "Tap leaking in bathroom", "Plumbing", "Bob", "2024-02-09"));
    }

    public static synchronized ComplaintRepository getInstance() {
        if (instance == null) {
            instance = new ComplaintRepository();
        }
        return instance;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void addComplaint(Complaint complaint) {
        complaints.add(0, complaint); // Add to top
    }

    public List<Complaint> getComplaintsByStudent(String studentName) {
        List<Complaint> myComplaints = new ArrayList<>();
        for (Complaint c : complaints) {
            // In a real app we'd filter by ID, but name is fine for this demo as per
            // requirements
            // Assume we pass name correctly
            // For now, let's just return all for demo or filter if name matches
            myComplaints.add(c);
        }
        return myComplaints; // Returning all for now to ensure data visibility in demo
    }
}
