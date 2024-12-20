package com.example.momentsjava.ui.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.momentsjava.data.model.ListItem;
import com.example.momentsjava.data.repository.ListRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ListViewModel extends ViewModel {

    private final ListRepository listRepository;
    private final MutableLiveData<List<ListItem>> listItems = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ListViewModel(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public LiveData<List<ListItem>> getListItems() {
        return listItems;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void fetchListItems() {
        compositeDisposable.clear();
        compositeDisposable.add(listRepository.getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        listItems::setValue,
                        throwable -> {
                            errorMessage.setValue(throwable.getMessage());
                        }
                ));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}