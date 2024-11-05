package com.example.simplelist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simplelist.ui.screens.ListItem
import com.example.simplelist.ui.screens.ListViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SimpleListApp(
    viewModel: ListViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val listItems =viewModel.listUiState

    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(listItems){item ->
            ListItem(
                title = item.title,
                description = item.description
            )
        }
    }
}