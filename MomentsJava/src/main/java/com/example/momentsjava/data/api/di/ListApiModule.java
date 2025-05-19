package com.example.momentsjava.data.api.di;

import com.example.momentsjava.data.api.ListApiService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ListApiModule {
    @Provides
    public static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://demo-list-server.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Provides
    public static ListApiService provideListApiService(Retrofit retrofit) {
        return retrofit.create(ListApiService.class);
    }
}