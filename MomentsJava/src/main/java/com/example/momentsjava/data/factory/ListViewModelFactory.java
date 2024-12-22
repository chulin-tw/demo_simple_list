package com.example.momentsjava.data.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.momentsjava.data.repository.ListRepository;
import com.example.momentsjava.ui.list.ListViewModel;

public class ListViewModelFactory implements ViewModelProvider.Factory {

    private final ListRepository listRepository;

    public ListViewModelFactory(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListViewModel.class)) {
            return (T) new ListViewModel(listRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}