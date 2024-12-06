package com.example.momentsjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.momentsjava.model.ListItem;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    Context context;
    List<ListItem> listItems;

    public ListItemAdapter(Context context, List<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListItemViewHolder(LayoutInflater.from(context).inflate(
                R.layout.list_item_view,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        holder.titleView.setText(listItems.get(position).getTitle());
        holder.descriptionView.setText(listItems.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}
