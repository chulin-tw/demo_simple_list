package com.example.momentsjava;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.momentsjava.data.model.ListItem;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    List<ListItem> listItems;

    public ListItemAdapter(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item_view,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        holder.titleView.setText(listItems.get(position).getUserInfo().getUsername());
        holder.descriptionView.setText(listItems.get(position).getMomentInfo().getText());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setListItems(List<ListItem> listItems) {
        this.listItems = listItems;
        notifyDataSetChanged();
    }
}
