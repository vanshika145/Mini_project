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

public class AllComplaintsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        // Reuse the view_complaints layout
        View view = inflater.inflate(R.layout.fragment_view_complaints, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
        toolbar.setTitle("All Complaints");

        RecyclerView rvComplaints = view.findViewById(R.id.rvComplaints);
        rvComplaints.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get ALL complaints
        List<Complaint> complaints = ComplaintRepository.getInstance().getComplaints();

        ComplaintAdapter adapter = new ComplaintAdapter(complaints, null); // Read-only
        rvComplaints.setAdapter(adapter);

        return view;
    }
}
