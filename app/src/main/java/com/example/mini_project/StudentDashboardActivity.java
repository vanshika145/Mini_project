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

public class StudentDashboardActivity extends AppCompatActivity {

    private CardView cardRaiseComplaint, cardMyComplaints, cardProfile, cardLogout;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cardRaiseComplaint = findViewById(R.id.cardRaiseComplaint);
        cardMyComplaints = findViewById(R.id.cardMyComplaints);
        cardProfile = findViewById(R.id.cardProfile);
        cardLogout = findViewById(R.id.cardLogout);

        cardRaiseComplaint.setOnClickListener(v -> {
            startActivity(new Intent(StudentDashboardActivity.this, RaiseComplaintActivity.class));
        });

        cardMyComplaints.setOnClickListener(v -> {
            Intent intent = new Intent(StudentDashboardActivity.this, ViewComplaintsActivity.class);
            intent.putExtra("USER_ROLE", "Student");
            startActivity(intent);
        });

        cardProfile.setOnClickListener(v -> {
            startActivity(new Intent(StudentDashboardActivity.this, ProfileActivity.class));
        });

        cardLogout.setOnClickListener(v -> {
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(StudentDashboardActivity.this, LoginActivity.class));
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
