package com.example.momentsjava.ui.list;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.momentsjava.R;
import com.example.momentsjava.data.model.ListItem;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private List<ListItem> listItems;

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
        holder.usernameView.setText(listItems.get(position).getUserInfo().getUsername());
        holder.contentView.setText(listItems.get(position).getMomentInfo().getText());
        Glide.with(holder.itemView)
                .load(listItems.get(position).getUserInfo().getAvatar())
                .transform(new RoundedCorners(12))
                .into(holder.userAvatarView);

        List<String> pictures = listItems.get(position).getMomentInfo().getPicture();

        LinearLayout picturesContainer = holder.picturesContainer;

        picturesContainer.removeAllViews();

        int rows = (int) Math.ceil(pictures.size() / 3.0);
        for (int row = 0; row < rows; row++) {
            LinearLayout rowLayout = new LinearLayout(holder.itemView.getContext());
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);
            rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            int startIndex = row * 3;
            int endIndex = Math.min(startIndex + 3, pictures.size());
            for (int i = startIndex; i < endIndex; i++) {
                ImageView pictureView = new ImageView(holder.itemView.getContext());
                Glide.with(holder.itemView)
                        .load(pictures.get(i))
                        .into(pictureView);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
                params.setMargins(0, 0, 4, 0);
                pictureView.setLayoutParams(params);
                rowLayout.addView(pictureView);
            }
            picturesContainer.addView(rowLayout);
        }

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
