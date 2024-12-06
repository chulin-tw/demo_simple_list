package com.example.momentsjava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.momentsjava.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //TODO: update it
        List<ListItem> listItems = new ArrayList<>();
        listItems.add(new ListItem("Title 1", "this is description 1"));
        listItems.add(new ListItem("Title 2", "this is description 2"));
        listItems.add(new ListItem("Title 3", "this is description 3"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListItemAdapter(getApplicationContext(), listItems));

    }
}