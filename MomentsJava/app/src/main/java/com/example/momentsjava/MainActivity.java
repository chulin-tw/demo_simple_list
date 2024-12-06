package com.example.momentsjava;

import static java.util.Collections.emptyList;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.momentsjava.model.ListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ListItemAdapter listItemAdapter;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItemAdapter = new ListItemAdapter(emptyList());
        recyclerView.setAdapter(listItemAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.205.19.77:3022")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ListApiService listApiService = retrofit.create(ListApiService.class);
        Call<List<ListItem>> call = listApiService.getList();
        call.enqueue(new Callback<List<ListItem>>() {
            @Override
            public void onResponse(@NonNull Call<List<ListItem>> call, Response<List<ListItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listItemAdapter.setListItems(response.body());
                    Log.d("MainActivity", "Data set to adapter");
                } else {
                    Toast.makeText(MainActivity.this, "Error:" + response.message(), Toast.LENGTH_LONG).show();
                    Log.e("MainActivity", "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ListItem>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Failure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("MainActivity", "Failure: " + t.getMessage(), t);
            }
        });


    }
}