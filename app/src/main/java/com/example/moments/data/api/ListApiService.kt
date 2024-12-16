package com.example.moments.data.api

import com.example.moments.data.model.ListItem
import retrofit2.http.GET

interface ListApiService {
    @GET("list")
    suspend fun getList(): List<ListItem>
}