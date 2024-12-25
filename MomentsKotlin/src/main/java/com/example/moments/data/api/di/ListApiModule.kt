package com.example.moments.data.api.di

import com.example.moments.data.api.ListApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val DOMAIN_URL = "192.168.31.17"

object ListApiModule {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://$DOMAIN_URL:3022")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun provideListApiService(retrofit: Retrofit): ListApiService {
        return retrofit.create(ListApiService::class.java)
    }
}