package com.example.momentsjava;

import static java.util.Collections.emptyList;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.momentsjava.ui.list.ListItemAdapter;
import com.example.momentsjava.ui.list.ListItemDivider;
import com.example.momentsjava.ui.list.ListViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ListItemAdapter listItemAdapter;
    private ListViewModel listViewModel;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
        setupViewModel();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListItemDivider divider = new ListItemDivider(recyclerView.getContext(), 16);
        recyclerView.addItemDecoration(divider);
        listItemAdapter = new ListItemAdapter(emptyList());
        recyclerView.setAdapter(listItemAdapter);
    }

    private void setupViewModel() {
        listViewModel = new ViewModelProvider(this).get(ListViewModel.class);
        listViewModel.getListItems().observe(this, listItems -> listItemAdapter.setListItems(listItems));
        listViewModel.getErrorMessage().observe(this, errorMessage -> Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show());
        listViewModel.fetchListItems();
    }

}