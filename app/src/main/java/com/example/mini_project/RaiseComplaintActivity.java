package com.example.mini_project;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public class RaiseComplaintActivity extends AppCompatActivity {

    private Spinner spinnerCategory;
    private MaterialButton btnSubmit;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise_complaint);

        toolbar = findViewById(R.id.toolbar);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        btnSubmit = findViewById(R.id.btnSubmitComplaint);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Dummy categories for the Spinner
        String[] categories = {"Electricity", "Water", "Cleaning", "Internet", "Others"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        btnSubmit.setOnClickListener(v -> {
            Toast.makeText(this, "Complaint Submitted Successfully!", Toast.LENGTH_LONG).show();
            finish();
        });
    }
}
