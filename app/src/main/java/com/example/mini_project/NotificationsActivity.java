package com.example.mini_project;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    private RecyclerView rvNotifications;
    private NotificationAdapter adapter;
    private List<Notification> notificationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        rvNotifications = findViewById(R.id.rvNotifications);
        rvNotifications.setLayoutManager(new LinearLayoutManager(this));

        notificationList = new ArrayList<>();
        loadDummyNotifications();

        adapter = new NotificationAdapter(notificationList);
        rvNotifications.setAdapter(adapter);
    }

    private void loadDummyNotifications() {
        notificationList.add(new Notification("Complaint Received", "Your complaint regarding the fan has been received.", "2 hours ago"));
        notificationList.add(new Notification("Status Updated", "The status for 'WiFi issue' is now 'In Progress'.", "5 hours ago"));
        notificationList.add(new Notification("Complaint Resolved", "Your complaint 'Broken Window' has been resolved.", "1 day ago"));
        notificationList.add(new Notification("Welcome", "Welcome to the Smart Hostel App!", "3 days ago"));
    }
}
