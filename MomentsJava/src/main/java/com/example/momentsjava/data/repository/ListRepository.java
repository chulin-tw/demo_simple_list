package com.example.momentsjava.data.repository;

import android.util.Log;

import com.example.momentsjava.data.datasource.ListDataSource;
import com.example.momentsjava.data.model.ListItem;

import java.util.List;

import jakarta.inject.Inject;
import retrofit2.Callback;

public class ListRepository {
    private final ListDataSource listDataSource;

    @Inject
    public ListRepository(ListDataSource listDataSource) {
        this.listDataSource = listDataSource;
    }

    public void getList(Callback<List<ListItem>> callback) {
        listDataSource.getList(callback);
    }
}
