package com.example.mini_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyComplaintsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_complaints, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
        toolbar.setTitle("My Complaints");

        RecyclerView rvComplaints = view.findViewById(R.id.rvComplaints);
        rvComplaints.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get complaints for this student
        String studentName = "Student";
        if (getActivity() instanceof StudentDashboardActivity) {
            studentName = ((StudentDashboardActivity) getActivity()).getUserName();
        }

        List<Complaint> complaints = ComplaintRepository.getInstance().getComplaintsByStudent(studentName);

        ComplaintAdapter adapter = new ComplaintAdapter(complaints, null); // null listener for read-only
        rvComplaints.setAdapter(adapter);

        return view;
    }
}
