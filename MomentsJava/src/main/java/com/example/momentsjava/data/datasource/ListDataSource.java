package com.example.momentsjava.data.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.momentsjava.data.api.ListApiService;
import com.example.momentsjava.data.api.di.ListApiModule;
import com.example.momentsjava.data.model.ListItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ListDataSource {

    private static final String PREFS_NAME = "javaMomentsList";
    private static final String LIST_KEY = "javaMomentsListItems";
    private final ListApiService listApiService = ListApiModule.provideListApiService(ListApiModule.provideRetrofit());
    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    public ListDataSource(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.gson = new Gson();
    }

    public Observable<List<ListItem>> getList() {
        return listApiService.getList()
                .doAfterNext(this::saveListToPreferences)
                .onErrorResumeNext(throwable -> {
                    List<ListItem> cachedList = getListFromPreferences();
                    if (cachedList != null) {
//                        Log.d("ListDataSource", "Returning cached list items: " + cachedList);
                        return Observable.just(cachedList);
                    } else {
//                        Log.d("ListDataSource", "Returning error: " + throwable.getMessage());
                        return Observable.error(throwable);
                    }
                });
    }

    private void saveListToPreferences(List<ListItem> listItems) {
//        Log.d("ListDataSource", "Saving list items to preferences: " + listItems);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listItems);
        editor.putString(LIST_KEY, json);
        editor.apply();
    }

    private List<ListItem> getListFromPreferences() {
        String json = sharedPreferences.getString(LIST_KEY, null);
        if (json != null) {
            Type type = new TypeToken<List<ListItem>>() {
            }.getType();
            return gson.fromJson(json, type);
        }
        return null;
    }
}
