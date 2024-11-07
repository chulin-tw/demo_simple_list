package com.example.simplelist.data.api

import com.example.simplelist.data.model.ListItem
import retrofit2.http.GET

interface ListApiService {
    @GET("list")
    suspend fun getList(): List<ListItem>
}