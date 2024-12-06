package com.example.momentsjava;

import com.example.momentsjava.model.ListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListApiService {
    @GET("list")
    Call<List<ListItem>> getList();
}
