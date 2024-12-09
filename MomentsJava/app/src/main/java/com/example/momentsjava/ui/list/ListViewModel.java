package com.example.momentsjava.ui.list;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.momentsjava.data.model.ListItem;
import com.example.momentsjava.data.repository.ListRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class ListViewModel extends ViewModel {

    private final ListRepository listRepository;
    private final MutableLiveData<List<ListItem>> listItems = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();

    @Inject
    public ListViewModel(ListRepository listRepository) {
        this.listRepository = listRepository;
        Log.d("Debug", "ListViewModel constructor called");
    }

    public LiveData<List<ListItem>> getListItems() {
        return listItems;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void fetchListItems() {
        listRepository.getList(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<ListItem>> call, @NonNull Response<List<ListItem>> response) {
                if (response.isSuccessful()) {
                    listItems.postValue(response.body());
                } else {
                    errorMessage.postValue("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ListItem>> call, @NonNull Throwable t) {
                errorMessage.postValue(t.getMessage());
            }
        });
    }
}