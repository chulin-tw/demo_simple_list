package com.example.moments.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.moments.data.api.di.ListApiModule
import com.example.moments.data.datasource.ListDataSource
import com.example.moments.data.repository.ListRepository
import com.example.moments.ui.list.ListViewModel
import com.example.moments.ui.momentsheader.MomentsHeader
import com.example.moments.ui.momentslist.MomentsList

@Composable
fun MomentsScreen(
    viewModel: ListViewModel = ListViewModel(
        listRepository = ListRepository(
            listDataSource = ListDataSource(
                listApiService = ListApiModule.provideListApiService(ListApiModule.provideRetrofit())
            )
        )
    ),
    modifier: Modifier = Modifier
) {
    val listItems = viewModel.list.value
    val isLoading = viewModel.loading
    LaunchedEffect(Unit) {
        viewModel.loadItems()
    }
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        MomentsHeader()
        MomentsList(
            listItems,
            isRefreshing = isLoading,
            onRefresh = { viewModel.loadItems() },
        )
    }
}


