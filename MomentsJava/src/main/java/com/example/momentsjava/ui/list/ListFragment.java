package com.example.momentsjava.ui.list;

import static java.util.Collections.emptyList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.momentsjava.R;
import com.example.momentsjava.data.api.ListApiClient;
import com.example.momentsjava.data.datasource.ListDataSource;
import com.example.momentsjava.data.factory.ListViewModelFactory;
import com.example.momentsjava.data.repository.ListRepository;

public class ListFragment extends Fragment {
    private ListItemAdapter listItemAdapter;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        setupRecyclerView(view);
        setupViewModel();
        return view;
    }

    private void setupRecyclerView(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListItemDivider divider = new ListItemDivider(recyclerView.getContext(), 16);
        recyclerView.addItemDecoration(divider);
        listItemAdapter = new ListItemAdapter(emptyList());
        recyclerView.setAdapter(listItemAdapter);
    }

    private void setupViewModel() {
        ListApiClient listApiClient = new ListApiClient();
        ListDataSource listDataSource = new ListDataSource(listApiClient);
        ListRepository listRepository = new ListRepository(listDataSource);
        ListViewModelFactory factory = new ListViewModelFactory(listRepository);
        ListViewModel listViewModel = new ViewModelProvider(requireActivity(), factory).get(ListViewModel.class);
        listViewModel.getListItems().observe(getViewLifecycleOwner(), listItems -> {
            listItemAdapter.setListItems(listItems);
            Log.d("ListFragment", "List items: " + listItems);
        });
        listViewModel.getErrorMessage().observe(getViewLifecycleOwner(), errorMessage -> {
            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
        });
        listViewModel.fetchListItems();
    }
}
