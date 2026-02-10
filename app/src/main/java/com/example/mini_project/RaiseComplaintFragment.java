package com.example.mini_project;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class RaiseComplaintFragment extends Fragment {

    private Spinner spinnerCategory;
    private TextInputEditText etTitle, etDesc;
    private MaterialButton btnSubmit;
    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_raise_complaint, container, false);

        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());

        spinnerCategory = view.findViewById(R.id.spinnerCategory);
        etTitle = view.findViewById(R.id.etComplaintTitle);
        etDesc = view.findViewById(R.id.etComplaintDesc);
        btnSubmit = view.findViewById(R.id.btnSubmitComplaint);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item,
                new String[] { "Electrical", "Plumbing", "Carpentry", "Other" });
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        btnSubmit.setOnClickListener(v -> {
            String title = etTitle.getText().toString();
            String desc = etDesc.getText().toString();
            String category = spinnerCategory.getSelectedItem().toString();

            if (TextUtils.isEmpty(title)) {
                etTitle.setError("Required");
                return;
            }

            StudentDashboardActivity activity = (StudentDashboardActivity) getActivity();
            String studentName = activity != null ? activity.getUserName() : "Unknown";
            String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

            Complaint complaint = new Complaint(UUID.randomUUID().toString(), title, desc, category, studentName, date);
            ComplaintRepository.getInstance().addComplaint(complaint);

            Toast.makeText(getContext(), "Complaint Registered!", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        });

        return view;
    }
}
