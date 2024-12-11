package com.example.momentsjava.ui.list;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

public class ListItemDivider extends DividerItemDecoration {
    private final int marginTop;


    public ListItemDivider(Context context, int marginTop) {
        super(context, VERTICAL);
        this.marginTop = marginTop;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, marginTop);
    }
}
