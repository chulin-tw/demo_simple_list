package com.example.momentsjava.ui.list;

import android.view.View;
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

public class ListItemViewHolder extends RecyclerView.ViewHolder {
    private final ListItemViewBinding binding;

    public ListItemViewHolder(@NonNull ListItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(ListItem listItem) {
        binding.setListItem(listItem);
        binding.executePendingBindings();
        Glide.with(itemView)
                .load(listItem.getUserInfo().getAvatar())
                .transform(new RoundedCorners(12))
                .into(binding.userAvatar);
        setPictures(listItem.getMomentInfo().getPicture(), binding.pictureContainer, itemView);
        setExpandableContent();
    }

    private void setExpandableContent() {
        binding.content.post(() -> {
            boolean isContentExpandable = binding.content.getLineCount() > 5;
            binding.content.setMaxLines(isContentExpandable ? 5 : Integer.MAX_VALUE);
            binding.expandToggle.setVisibility(isContentExpandable ? View.VISIBLE : View.GONE);
        });
        binding.expandToggle.setOnClickListener(v -> {
            String expandText = itemView.getContext().getString(R.string.expandText);
            String foldText = itemView.getContext().getString(R.string.foldText);
            boolean isExpanded = binding.expandToggle.getText().equals(expandText);
            binding.content.setMaxLines(isExpanded ? Integer.MAX_VALUE : 5);
            binding.expandToggle.setText(isExpanded ? foldText : expandText);
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
}