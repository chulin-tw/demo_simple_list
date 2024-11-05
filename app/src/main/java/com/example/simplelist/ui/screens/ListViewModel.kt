package com.example.simplelist.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplelist.model.ListItem
import com.example.simplelist.network.ListApi
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    var listUiState: List<ListItem> by mutableStateOf(emptyList())
        private set

    init {
        getList()
    }

    fun getList() {
        viewModelScope.launch {
            try {
                val response = ListApi.retrofitService.getList()
                Log.d("ListViewModel", "Data: $response")
                listUiState = response
            } catch (e: Exception) {
                Log.e("ListViewModel", "Error: ${e.message}")
            }
        }
    }
}