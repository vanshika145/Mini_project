package com.example.mini_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;

public class StudentHomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_home, container, false);

        StudentDashboardActivity activity = (StudentDashboardActivity) getActivity();
        String name = activity != null ? activity.getUserName() : "Student";

        TextView tvWelcome = view.findViewById(R.id.tvWelcomeName);
        tvWelcome.setText("Hello " + name); // "Dashboard header must show: Hello <Name>"

        MaterialCardView cardRaiseComplaint = view.findViewById(R.id.cardRaiseComplaint);
        MaterialCardView cardMyComplaints = view.findViewById(R.id.cardMyComplaints);
        MaterialCardView cardProfile = view.findViewById(R.id.cardProfile);
        MaterialCardView cardLogout = view.findViewById(R.id.cardLogout);

        cardRaiseComplaint.setOnClickListener(v -> activity.loadFragment(new RaiseComplaintFragment(), true));
        cardMyComplaints.setOnClickListener(v -> activity.loadFragment(new MyComplaintsFragment(), true));
        cardProfile.setOnClickListener(v -> activity.loadFragment(new ProfileFragment(), true));

        cardLogout.setOnClickListener(v -> {
            startActivity(new Intent(activity, LoginActivity.class));
            activity.finish();
        });

        return view;
    }
}
