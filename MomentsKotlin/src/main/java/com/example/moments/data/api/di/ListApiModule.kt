package com.example.moments.data.api.di

import com.example.moments.data.api.ListApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val DOMAIN_URL = "192.168.31.246"

object ListApiModule {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://$DOMAIN_URL:3022")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideListApiService(retrofit: Retrofit): ListApiService {
        return retrofit.create(ListApiService::class.java)
    }
}