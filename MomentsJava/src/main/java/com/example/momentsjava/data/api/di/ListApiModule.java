package com.example.momentsjava.data.api.di;

import com.example.momentsjava.data.api.ListApiService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ListApiModule {

    private static final String DOMAIN_URL = "10.205.19.77";

    @Provides
    public static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://" + DOMAIN_URL + ":3022")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public static ListApiService provideListApiService(Retrofit retrofit) {
        return retrofit.create(ListApiService.class);
    }
}