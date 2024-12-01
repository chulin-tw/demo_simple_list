package com.example.moments.ui

import android.util.Log
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
fun MomentsApp(
    viewModel: ListViewModel = hiltViewModel(), modifier: Modifier = Modifier
) {
    val listItems = viewModel.list.value
    Log.d("BUU", "listitem:${listItems}")
    LaunchedEffect(Unit) {
        viewModel.loadItems()
    }

    LazyColumn() {
        items(listItems) { item ->
            MomentsHeader()
            ListItem(
                avatar = item.userInfo.avatar,
                userName = item.userInfo.username,
                text = item.momentInfo.text,
            )
        }
    }
//    viewModel.loadItems()

}


