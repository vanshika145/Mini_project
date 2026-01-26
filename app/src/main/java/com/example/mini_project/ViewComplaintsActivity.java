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
        complaintList.add(new Complaint("Leaking tap in washroom", "Water", "Pending", "25 Oct 2023"));
        complaintList.add(new Complaint("Fan not working", "Electricity", "In Progress", "24 Oct 2023"));
        complaintList.add(new Complaint("WiFi signal weak", "Internet", "Resolved", "22 Oct 2023"));
        complaintList.add(new Complaint("Room cleaning requested", "Cleaning", "Pending", "25 Oct 2023"));
        complaintList.add(new Complaint("Broken window glass", "Others", "Resolved", "20 Oct 2023"));
    }
}
