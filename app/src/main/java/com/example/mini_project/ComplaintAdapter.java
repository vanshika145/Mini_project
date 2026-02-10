package com.example.mini_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ComplaintViewHolder> {

    private List<Complaint> complaintList;
    private OnItemClickListener listener;

    public ComplaintAdapter(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public ComplaintAdapter(List<Complaint> complaintList, OnItemClickListener listener) {
        this.complaintList = complaintList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ComplaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_complaint, parent, false);
        return new ComplaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintViewHolder holder, int position) {
        Complaint complaint = complaintList.get(position);
        holder.tvTitle.setText(complaint.getTitle());
        holder.tvCategory.setText("Category: " + complaint.getCategory());
        holder.tvStatus.setText(complaint.getStatus());
        holder.tvDate.setText("Date: " + complaint.getDate());

        // Simple UI coloring based on status
        if (complaint.getStatus().equalsIgnoreCase("Pending")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_pending);
        } else if (complaint.getStatus().equalsIgnoreCase("In Progress")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_in_progress);
        } else {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_resolved);
        }

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(complaint);
            }
        });
    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }

    public static class ComplaintViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvCategory, tvStatus, tvDate;

        public ComplaintViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvItemTitle);
            tvCategory = itemView.findViewById(R.id.tvItemCategory);
            tvStatus = itemView.findViewById(R.id.tvItemStatus);
            tvDate = itemView.findViewById(R.id.tvItemDate);
        }
    }
}
