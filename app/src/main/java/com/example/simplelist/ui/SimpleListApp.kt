package com.example.simplelist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simplelist.R
import com.example.simplelist.ui.list.ListViewModel

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
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
        ){
            Image(
                painter = painterResource(id = R.drawable.default_background),
                contentDescription = "default_background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Image(
                painter = painterResource(id = R.drawable.default_avatar),
                contentDescription = "default_avatar",
                modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.BottomEnd)
                    .offset((-24).dp,(24).dp)
            )
        }
        Text("Hello World", modifier = modifier.fillMaxSize())

    }

}