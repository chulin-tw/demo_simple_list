package com.example.moments.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moments.ui.list.ListViewModel
import com.example.moments.ui.listitem.ListItem
import com.example.moments.ui.momentsheader.MomentsHeader

@Composable
fun MomentsScreen(
    viewModel: ListViewModel = hiltViewModel(), modifier: Modifier = Modifier
) {
    val listItems = viewModel.list.value
    LaunchedEffect(Unit) {
        viewModel.loadItems()
    }
    Column(modifier = Modifier.fillMaxSize()) {
        MomentsHeader()
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(listItems) { item ->
                ListItem(
                    avatar = item.userInfo.avatar,
                    userName = item.userInfo.username,
                    text = item.momentInfo.text,
                    pictures = item.momentInfo.picture
                )
            }
        }
    }
}


