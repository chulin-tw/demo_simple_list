package com.example.moments.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moments.ui.list.ListViewModel
import com.example.moments.ui.momentsheader.MomentsHeader
import com.example.moments.ui.momentslist.MomentsList

@Composable
fun MomentsScreen(
    viewModel: ListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
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
        MomentsList(listItems)
    }
}


