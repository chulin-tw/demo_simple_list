package com.example.momentsjava.data.datasource;

import android.util.Log;

import com.example.momentsjava.data.api.ListApiService;
import com.example.momentsjava.data.model.ListItem;

import java.util.List;

import jakarta.inject.Inject;
import retrofit2.Callback;

public class ListDataSource {

    private final ListApiService listApiService;

    @Inject
    public ListDataSource(ListApiService listApiService) {
        this.listApiService = listApiService;
    }

    public void getList(Callback<List<ListItem>> callback) {
        listApiService.getList().enqueue(callback);
    }
}
