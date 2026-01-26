package com.example.mini_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

/**
 * HomeActivity - Dashboard with Card-style navigation.
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Binding UI elements
        TextView tvWelcome = findViewById(R.id.tvWelcomeHome);
        CardView cardRaise = findViewById(R.id.cardRaiseComplaint);
        CardView cardView = findViewById(R.id.cardViewComplaints);
        CardView cardLogout = findViewById(R.id.cardLogout);

        // DUMMY DATA: Display welcome message
        tvWelcome.setText("Welcome, Student");

        // Navigate to Raise Complaint
        cardRaise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RaiseComplaintActivity.class);
                startActivity(intent);
            }
        });

        // View Complaints - UI placeholder
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Viewing your submitted complaints...", Toast.LENGTH_SHORT).show();
            }
        });

        // Logout logic
        cardLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}