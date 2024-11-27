package com.example.moments.ui.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moments.data.model.ListItem
import com.example.moments.data.repository.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val listRepository: ListRepository) : ViewModel() {
    private val _list = mutableStateOf<List<ListItem>>(emptyList())
    val list: State<List<ListItem>> = _list

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    fun loadItems() {
        viewModelScope.launch {
            val result = listRepository.getList()
            when {
                result.isSuccess -> {
                    _list.value = result.getOrNull() ?: emptyList()
                }

                result.isFailure -> {
                    _error.value = result.exceptionOrNull()?.message
                }
            }
        }
    }
}