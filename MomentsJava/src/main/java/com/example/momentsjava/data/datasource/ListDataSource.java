package com.example.momentsjava.data.datasource;

import com.example.momentsjava.data.api.ListApiClient;
import com.example.momentsjava.data.model.ListItem;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ListDataSource {

    private final ListApiClient listApiClient;

    public ListDataSource(ListApiClient listApiClient) {
        this.listApiClient = listApiClient;
    }

    public Observable<List<ListItem>> getList() {
        return listApiClient.getList();
    }
}
