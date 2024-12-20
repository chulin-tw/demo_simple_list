package com.example.moments.ui.list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moments.data.model.ListItem
import com.example.moments.data.repository.ListRepository
import kotlinx.coroutines.launch

class ListViewModel(private val listRepository: ListRepository) : ViewModel() {
    private val _list = mutableStateOf<List<ListItem>>(emptyList())
    val list: State<List<ListItem>> = _list
    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    fun loadItems() {
        viewModelScope.launch {
            val result = listRepository.getList()
            when {
                result.isSuccess -> {
                    val data = result.getOrNull() ?: emptyList()
                    _list.value = data
                    Log.d("ListViewModel", "Data loaded: $data")
                }

                result.isFailure -> {
                    val errorMessage = result.exceptionOrNull()?.message
                    _error.value = errorMessage
                    Log.e("ListViewModel", "Error loading data: $errorMessage")
                }
            }
        }
    }
}