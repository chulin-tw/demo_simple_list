package com.example.simplelist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simplelist.ui.list.ListItem
import com.example.simplelist.ui.list.ListViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SimpleListApp(
    viewModel: ListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val listItems = viewModel.list.value

    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(listItems) { item ->
            ListItem(
                title = item.title,
                description = item.description,
                image = item.image
            )
        }
    }
    viewModel.loadItems()
}