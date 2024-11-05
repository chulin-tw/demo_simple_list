package com.example.simplelist.network

import com.example.simplelist.model.ListItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:3022"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ListApiService{
    @GET("list")
    suspend fun getList():List<ListItem>
}

object ListApi{
    val retrofitService: ListApiService by lazy {
        retrofit.create(ListApiService::class.java)
    }
}
