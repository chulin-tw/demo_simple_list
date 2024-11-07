package com.example.simplelist.data.repository

import com.example.simplelist.data.datasource.ListDataSource
import com.example.simplelist.data.model.ListItem
import javax.inject.Inject

class ListRepository @Inject constructor(private val listDataSource: ListDataSource) {
    suspend fun getList(): Result<List<ListItem>> {
        return listDataSource.fetchList()
    }
}
