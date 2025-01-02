package com.example.momentsjava.ui.list;

import static java.util.Collections.emptyList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.momentsjava.data.datasource.ListDataSource;
import com.example.momentsjava.data.factory.ListViewModelFactory;
import com.example.momentsjava.data.repository.ListRepository;
import com.example.momentsjava.databinding.ListFragmentBinding;

public class ListFragment extends Fragment {
    private ListItemAdapter listItemAdapter;
    private ListFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ListFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        setupRecyclerView();
        setupViewModel();
        setupSwipeRefreshLayout();
        return view;
    }

    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ListItemDivider divider = new ListItemDivider(requireContext(), 16);
        binding.recyclerView.addItemDecoration(divider);
        listItemAdapter = new ListItemAdapter(emptyList());
        binding.recyclerView.setAdapter(listItemAdapter);
    }

    private void setupViewModel() {
        ListDataSource listDataSource = new ListDataSource();
        ListRepository listRepository = new ListRepository(listDataSource);
        ListViewModelFactory factory = new ListViewModelFactory(listRepository);
        ListViewModel listViewModel = new ViewModelProvider(requireActivity(), factory).get(ListViewModel.class);
        listViewModel.getListItems().observe(getViewLifecycleOwner(), listItems -> {
            listItemAdapter.setListItems(listItems);
            binding.swipeRefreshLayout.setRefreshing(false);
            Log.d("ListFragment", "List items: " + listItems);
        });
        listViewModel.getErrorMessage().observe(getViewLifecycleOwner(), errorMessage -> {
            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
            binding.swipeRefreshLayout.setRefreshing(false);
        });
        listViewModel.fetchListItems();
    }

    private void setupSwipeRefreshLayout() {
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            ListViewModel listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
            listViewModel.fetchListItems();
        });
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
