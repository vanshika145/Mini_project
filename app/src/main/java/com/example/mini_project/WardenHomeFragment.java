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

public class WardenHomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warden_dashboard, container, false);

        WardenDashboardActivity activity = (WardenDashboardActivity) getActivity();
        String name = activity != null ? activity.getUserName() : "Warden";

        TextView tvWelcome = view.findViewById(R.id.tvWelcomeWarden);
        tvWelcome.setText("Hello " + name);

        MaterialCardView cardAllComplaints = view.findViewById(R.id.cardAllComplaints);
        MaterialCardView cardUpdateStatus = view.findViewById(R.id.cardUpdateStatus);
        MaterialCardView cardProfile = view.findViewById(R.id.cardWardenProfile);
        MaterialCardView cardLogout = view.findViewById(R.id.cardWardenLogout);

        cardAllComplaints.setOnClickListener(v -> activity.loadFragment(new AllComplaintsFragment(), true));
        cardUpdateStatus.setOnClickListener(v -> activity.loadFragment(new UpdateStatusFragment(), true));
        cardProfile.setOnClickListener(v -> activity.loadFragment(new ProfileFragment(), true)); // Reuse
                                                                                                 // ProfileFragment

        cardLogout.setOnClickListener(v -> {
            startActivity(new Intent(activity, LoginActivity.class));
            activity.finish();
        });

        return view;
    }
}
