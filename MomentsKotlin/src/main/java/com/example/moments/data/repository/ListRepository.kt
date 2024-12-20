package com.example.moments.data.repository

import com.example.moments.data.datasource.ListDataSource
import com.example.moments.data.model.ListItem

class ListRepository(private val listDataSource: ListDataSource) {
    suspend fun getList(): Result<List<ListItem>> {
        return listDataSource.fetchList()
    }
}
