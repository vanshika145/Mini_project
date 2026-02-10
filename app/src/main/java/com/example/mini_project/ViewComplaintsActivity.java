package com.example.mini_project;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.List;

public class ViewComplaintsActivity extends AppCompatActivity {

    private RecyclerView rvComplaints;
    private ComplaintAdapter adapter;
    private List<Complaint> complaintList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        rvComplaints = findViewById(R.id.rvComplaints);
        rvComplaints.setLayoutManager(new LinearLayoutManager(this));

        // Initialize dummy data
        complaintList = new ArrayList<>();
        loadDummyComplaints();

        adapter = new ComplaintAdapter(complaintList);
        rvComplaints.setAdapter(adapter);

        // Set title based on role if passed
        String role = getIntent().getStringExtra("USER_ROLE");
        if (role != null) {
            getSupportActionBar().setTitle(role.equals("Warden") ? "All Complaints" : "My Complaints");
        }
    }

    private void loadDummyComplaints() {
        Complaint c1 = new Complaint("1", "Leaking tap in washroom", "Tap is leaking continuously.", "Water", "Student",
                "25 Oct 2023");
        c1.setStatus("Pending");
        complaintList.add(c1);

        Complaint c2 = new Complaint("2", "Fan not working", "Ceiling fan in room 101 is broken.", "Electricity",
                "Student", "24 Oct 2023");
        c2.setStatus("In Progress");
        complaintList.add(c2);

        Complaint c3 = new Complaint("3", "WiFi signal weak", "Cannot connect to WiFi in corridor.", "Internet",
                "Student", "22 Oct 2023");
        c3.setStatus("Resolved");
        complaintList.add(c3);

        Complaint c4 = new Complaint("4", "Room cleaning requested", "Room needs mopping.", "Cleaning", "Student",
                "25 Oct 2023");
        c4.setStatus("Pending");
        complaintList.add(c4);

        Complaint c5 = new Complaint("5", "Broken window glass", "Window pane cracked.", "Others", "Student",
                "20 Oct 2023");
        c5.setStatus("Resolved");
        complaintList.add(c5);
    }
}
