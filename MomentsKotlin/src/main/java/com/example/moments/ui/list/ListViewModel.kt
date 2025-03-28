package com.example.moments.ui.list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moments.data.model.ListItem
import com.example.moments.data.repository.ListRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

class ListViewModel(private val listRepository: ListRepository) : ViewModel() {
    private val _list = mutableStateOf<List<ListItem>>(emptyList())
    val list: State<List<ListItem>> = _list
    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error
    private val _loading = mutableStateOf(false)
    val loading: State<Boolean> = _loading

    fun loadItems() {
        viewModelScope.launch {
            try {
                _loading.value = true
                delay(200)
                _list.value = listRepository.getList()
            } catch (e: IOException) {
//                Log.e("ListViewModel", e.toString())
                _error.value = e.toString()
            } finally {
                _loading.value = false
            }
        }
    }
}