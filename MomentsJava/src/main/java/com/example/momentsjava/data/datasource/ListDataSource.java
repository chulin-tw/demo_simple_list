package com.example.momentsjava.data.datasource;

import com.example.momentsjava.data.api.ListApiService;
import com.example.momentsjava.data.api.di.ListApiModule;
import com.example.momentsjava.data.model.ListItem;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ListDataSource {

    private final ListApiService listApiService = ListApiModule.provideListApiService(ListApiModule.provideRetrofit());

    public Observable<List<ListItem>> getList() {
        return listApiService.getList();
    }
}
