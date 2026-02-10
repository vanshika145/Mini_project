package com.example.mini_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());

        TextView tvName = view.findViewById(R.id.tvProfileName);
        TextView tvRole = view.findViewById(R.id.tvProfileRole);
        LinearLayout layoutEmail = view.findViewById(R.id.layoutEmail);

        // "Profile shows only name (not email)"
        // Hide email section
        if (layoutEmail != null) {
            layoutEmail.setVisibility(View.GONE);
        }

        // Get User details (from Activity)
        // Note: For Warden, we might reuse this fragment or duplicate.
        // If reusing, we need to know if it's Warden or Student.
        // For now assuming StudentDashboardActivity context, but checking safely.

        String name = "User";
        String role = "Student";

        if (getActivity() instanceof StudentDashboardActivity) {
            name = ((StudentDashboardActivity) getActivity()).getUserName();
            role = "Student";
        } else if (getActivity() instanceof WardenDashboardActivity) {
            name = ((WardenDashboardActivity) getActivity()).getUserName();
            role = "Warden";
        }

        tvName.setText(name);
        tvRole.setText(role);

        return view;
    }
}
