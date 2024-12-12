package com.example.momentsjava.ui.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.momentsjava.R;

public class ListItemViewHolder extends RecyclerView.ViewHolder {
    TextView usernameView,contentView;
    ImageView userAvatarView;
    LinearLayout picturesContainer;

    public ListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        usernameView = itemView.findViewById(R.id.username);
        contentView = itemView.findViewById(R.id.content);
        userAvatarView = itemView.findViewById(R.id.user_avatar);
        picturesContainer = itemView.findViewById(R.id.picture_container);
    }
}
