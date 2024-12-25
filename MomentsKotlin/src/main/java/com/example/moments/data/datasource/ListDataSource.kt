package com.example.moments.data.datasource

import com.example.moments.data.api.ListApiService
import com.example.moments.data.model.ListItem

class ListDataSource(private val listApiService: ListApiService) {
    suspend fun fetchList(): List<ListItem> {
        return listApiService.getList()
    }
}
