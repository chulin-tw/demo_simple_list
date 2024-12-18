package com.example.momentsjava.ui.list;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
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

        setPictures(listItems.get(position).getMomentInfo().getPicture(), holder.picturesContainer, holder.itemView);

    }

    private void setPictures(List<String> pictures, LinearLayout picturesContainer, View itemView) {
        picturesContainer.removeAllViews();

        int rows = (int) Math.ceil(pictures.size() / 3.0);
        for (int row = 0; row < rows; row++) {
            LinearLayout rowLayout = createRowLayout(itemView);
            addPicturesToRow(pictures, row, rowLayout, itemView);
            picturesContainer.addView(rowLayout);
        }
    }

    private LinearLayout createRowLayout(View itemView) {
        LinearLayout rowLayout = new LinearLayout(itemView.getContext());
        rowLayout.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return rowLayout;
    }

    private void addPicturesToRow(List<String> pictures, int row, LinearLayout rowLayout, View itemView) {
        int startIndex = row * 3;
        int endIndex = Math.min(startIndex + 3, pictures.size());
        for (int i = startIndex; i < endIndex; i++) {
            ImageView pictureView = createPictureView(pictures.get(i), itemView);
            rowLayout.addView(pictureView);
        }
    }

    private ImageView createPictureView(String pictureUrl, View itemView) {
        ImageView pictureView = new ImageView(itemView.getContext());
        Glide.with(itemView)
                .load(pictureUrl)
                .apply(new RequestOptions().centerCrop())
                .into(pictureView);

        int width = (int) (110 * itemView.getContext().getResources().getDisplayMetrics().density);
        int height = (int) (110 * itemView.getContext().getResources().getDisplayMetrics().density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        params.setMargins(0, 0, 8, 8);
        pictureView.setLayoutParams(params);
        return pictureView;
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
