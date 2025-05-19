package com.example.moments.data.api.di

import com.example.moments.data.api.ListApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ListApiModule {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://demo-list-server.vercel.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun provideListApiService(retrofit: Retrofit): ListApiService {
        return retrofit.create(ListApiService::class.java)
    }
}