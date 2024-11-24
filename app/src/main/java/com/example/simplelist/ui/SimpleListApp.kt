package com.example.simplelist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simplelist.R
import com.example.simplelist.ui.list.ListViewModel

@Composable
fun SimpleListApp(
    viewModel: ListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
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
    Text("Hello World", modifier = modifier.fillMaxSize())
    Image(
        painter = painterResource(id = R.drawable.default_avatar),
        contentDescription = "default_avatar",
        modifier = Modifier.size(100.dp)
    )
    Image(
        painter = painterResource(id = R.drawable.default_background),
        contentDescription = "default_avatar",
        modifier = Modifier.size(100.dp)
    )

}