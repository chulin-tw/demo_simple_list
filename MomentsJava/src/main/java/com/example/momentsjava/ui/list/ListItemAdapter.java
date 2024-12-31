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
import com.example.momentsjava.databinding.ListItemViewBinding;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private List<ListItem> listItems;

    public ListItemAdapter(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemViewBinding binding = ListItemViewBinding.inflate(inflater, parent, false);
        return new ListItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.binding.setListItem(listItem);
        holder.binding.executePendingBindings();
        Glide.with(holder.itemView)
                .load(listItem.getUserInfo().getAvatar())
                .transform(new RoundedCorners(12))
                .into(holder.binding.userAvatar);
        setPictures(listItem.getMomentInfo().getPicture(), holder.binding.pictureContainer, holder.itemView);
        setExpandableContent(holder);
    }

    private static void setExpandableContent(@NonNull ListItemViewHolder holder) {
        holder.binding.content.post(() -> {
            boolean isContentExpandable = holder.binding.content.getLineCount() > 5;
            holder.binding.content.setMaxLines(isContentExpandable ? 5 : Integer.MAX_VALUE);
            holder.binding.expandToggle.setVisibility(isContentExpandable ? View.VISIBLE : View.GONE);
        });
        holder.binding.expandToggle.setOnClickListener(v -> {
            String expandText = holder.itemView.getContext().getString(R.string.expandText);
            String foldText = holder.itemView.getContext().getString(R.string.foldText);
            boolean isExpanded = holder.binding.expandToggle.getText().equals(expandText);
            holder.binding.content.setMaxLines(isExpanded ? Integer.MAX_VALUE : 5);
            holder.binding.expandToggle.setText(isExpanded ? foldText : expandText);
        });
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
