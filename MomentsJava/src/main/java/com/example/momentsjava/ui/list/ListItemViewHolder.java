package com.example.momentsjava.ui.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.momentsjava.databinding.ListItemViewBinding;

public class ListItemViewHolder extends RecyclerView.ViewHolder {
    final ListItemViewBinding binding;

    public ListItemViewHolder(@NonNull ListItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
