package com.example.moments.data.api.di

import com.example.moments.data.api.ListApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val DOMAIN_URL = "192.168.31.221"

@Module
@InstallIn(SingletonComponent::class)
object ListApiModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://$DOMAIN_URL:3022")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideListApiService(retrofit: Retrofit): ListApiService {
        return retrofit.create(ListApiService::class.java)
    }
}
