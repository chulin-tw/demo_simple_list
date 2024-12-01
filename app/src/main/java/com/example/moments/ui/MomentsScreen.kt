package com.example.moments.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        MomentsHeader()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 48.dp
                )
        ) {
            items(listItems) { item ->
                ListItem(
                    avatar = item.userInfo.avatar,
                    userName = item.userInfo.username,
                    text = item.momentInfo.text,
                    pictures = item.momentInfo.picture
                )
                //TODO: divider fill max width,use another way to add padding
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    thickness = 0.5.dp
                )
            }
        }
    }
}


