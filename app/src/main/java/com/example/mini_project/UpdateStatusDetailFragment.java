package com.example.mini_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public class UpdateStatusDetailFragment extends Fragment {

    private Complaint complaint;
    private Spinner spinnerStatus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_status, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());

        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvDesc = view.findViewById(R.id.tv_description);
        spinnerStatus = view.findViewById(R.id.spinner_status);
        MaterialButton btnUpdate = view.findViewById(R.id.btn_update_status);

        String complaintId = getArguments() != null ? getArguments().getString("COMPLAINT_ID") : null;

        // Find complaint
        if (complaintId != null) {
            for (Complaint c : ComplaintRepository.getInstance().getComplaints()) {
                if (c.getId().equals(complaintId)) {
                    complaint = c;
                    break;
                }
            }
        }

        if (complaint != null) {
            tvTitle.setText(complaint.getTitle());
            tvDesc.setText(complaint.getDescription());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item,
                new String[] { "Pending", "In Progress", "Resolved", "Rejected" });
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapter);

        // Set current selection
        if (complaint != null) {
            int spinnerPosition = adapter.getPosition(complaint.getStatus());
            spinnerStatus.setSelection(spinnerPosition);
        }

        btnUpdate.setOnClickListener(v -> {
            if (complaint != null) {
                String newStatus = spinnerStatus.getSelectedItem().toString();
                complaint.setStatus(newStatus);
                Toast.makeText(getContext(), "Status Updated to " + newStatus, Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            }
        });

        return view;
    }
}
