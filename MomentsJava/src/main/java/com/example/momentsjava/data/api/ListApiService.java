package com.example.momentsjava.data.api;

import com.example.momentsjava.data.model.ListItem;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ListApiService {
    @GET("list")
    Observable<List<ListItem>> getList();
}
