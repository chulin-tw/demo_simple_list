package com.example.moments.data.repository

import com.example.moments.data.datasource.ListDataSource
import com.example.moments.data.model.ListItem
import javax.inject.Inject

class ListRepository @Inject constructor(private val listDataSource: ListDataSource) {
    suspend fun getList(): Result<List<ListItem>> {
        return listDataSource.fetchList()
    }
}
