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
import android.widget.Toast;

public class UpdateStatusFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_complaints, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
        toolbar.setTitle("Select Complaint to Update");

        RecyclerView rvComplaints = view.findViewById(R.id.rvComplaints);
        rvComplaints.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Complaint> complaints = ComplaintRepository.getInstance().getComplaints();

        ComplaintAdapter adapter = new ComplaintAdapter(complaints, complaint -> {
            // Handle click: Open Detail Fragment
            UpdateStatusDetailFragment detailFragment = new UpdateStatusDetailFragment();
            Bundle args = new Bundle();
            args.putString("COMPLAINT_ID", complaint.getId());
            detailFragment.setArguments(args);

            if (getActivity() instanceof WardenDashboardActivity) {
                ((WardenDashboardActivity) getActivity()).loadFragment(detailFragment, true);
            }
        });
        rvComplaints.setAdapter(adapter);

        return view;
    }
}
