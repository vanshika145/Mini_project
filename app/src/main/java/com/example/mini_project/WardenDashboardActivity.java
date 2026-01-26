package com.example.mini_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.appbar.MaterialToolbar;

public class WardenDashboardActivity extends AppCompatActivity {

    private CardView cardAllComplaints, cardUpdateStatus, cardWardenProfile, cardWardenLogout;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warden_dashboard);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cardAllComplaints = findViewById(R.id.cardAllComplaints);
        cardUpdateStatus = findViewById(R.id.cardUpdateStatus);
        cardWardenProfile = findViewById(R.id.cardWardenProfile);
        cardWardenLogout = findViewById(R.id.cardWardenLogout);

        cardAllComplaints.setOnClickListener(v -> {
            Intent intent = new Intent(WardenDashboardActivity.this, ViewComplaintsActivity.class);
            intent.putExtra("USER_ROLE", "Warden");
            startActivity(intent);
        });

        cardUpdateStatus.setOnClickListener(v -> {
            Toast.makeText(this, "Select a complaint to update its status", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(WardenDashboardActivity.this, ViewComplaintsActivity.class);
            intent.putExtra("USER_ROLE", "Warden");
            startActivity(intent);
        });

        cardWardenProfile.setOnClickListener(v -> {
            startActivity(new Intent(WardenDashboardActivity.this, ProfileActivity.class));
        });

        cardWardenLogout.setOnClickListener(v -> {
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(WardenDashboardActivity.this, LoginActivity.class));
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_notifications) {
            startActivity(new Intent(this, NotificationsActivity.class));
            return true;
        } else if (id == R.id.action_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
