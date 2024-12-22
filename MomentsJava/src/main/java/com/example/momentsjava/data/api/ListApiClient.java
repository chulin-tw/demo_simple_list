package com.example.momentsjava.data.api;

import android.util.Log;

import com.example.momentsjava.data.model.ListItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;


public class ListApiClient {

    private static final String DOMAIN_URL = "10.205.19.77";
    private static final int TIMEOUT = 10000;

    public Observable<List<ListItem>> getList() {
        return Observable.create(emitter -> {
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) new URL("http://" + DOMAIN_URL + ":3022/list").openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(TIMEOUT);
                connection.setReadTimeout(10000);

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                    StringBuilder response = new StringBuilder();
                    int data;
                    while ((data = reader.read()) != -1) {
                        response.append((char) data);
                    }

                    List<ListItem> listItems = parseJsonToList(response.toString());
                    emitter.onNext(listItems);
                    emitter.onComplete();
                } else {
                    Log.d("ListApiClient", "Error: HTTP " + responseCode);
                    emitter.onError(new Exception("Error: HTTP " + responseCode));
                }
            } catch (Exception e) {
                Log.d("ListApiClient", "Error: " + e.getMessage());
                emitter.onError(e);
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        });
    }

    private List<ListItem> parseJsonToList(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<ListItem>>() {
        }.getType();
        return gson.fromJson(json, listType);
    }
}
