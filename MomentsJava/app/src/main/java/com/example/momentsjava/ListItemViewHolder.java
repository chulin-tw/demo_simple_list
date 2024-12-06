package com.example.momentsjava;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListItemViewHolder extends RecyclerView.ViewHolder {
    TextView titleView,descriptionView;
    public ListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        titleView = itemView.findViewById(R.id.title);
        descriptionView = itemView.findViewById(R.id.description);
    }
}
