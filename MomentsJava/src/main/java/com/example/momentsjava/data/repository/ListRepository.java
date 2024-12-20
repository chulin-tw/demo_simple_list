package com.example.momentsjava.data.repository;

import com.example.momentsjava.data.datasource.ListDataSource;
import com.example.momentsjava.data.model.ListItem;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ListRepository {
    private final ListDataSource listDataSource;

    public ListRepository(ListDataSource listDataSource) {
        this.listDataSource = listDataSource;
    }

    public Observable<List<ListItem>> getList() {
        return listDataSource.getList();
    }
}
