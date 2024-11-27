package com.example.simplelist.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simplelist.ui.list.ListViewModel
import com.example.simplelist.ui.momentheader.MomentsHeader

@Composable
fun SimpleListApp(
    viewModel: ListViewModel = hiltViewModel(), modifier: Modifier = Modifier
) {
//    val listItems = viewModel.list.value
//
//    LazyColumn(modifier = modifier.fillMaxSize()) {
//        items(listItems) { item ->
//            ListItem(
//                title = item.title,
//                description = item.description,
//                image = item.image
//            )
//        }
//    }
//    viewModel.loadItems()
    MomentsHeader()
}


