package com.example.simplelist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simplelist.ui.screens.ListItem

@Composable
fun SimpleListApp(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(5) { index ->
            ListItem("Item ${index + 1}", " This is text ${index + 1}.")
        }
    }
}