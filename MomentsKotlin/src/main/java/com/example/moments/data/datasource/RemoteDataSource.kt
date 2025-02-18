package com.example.moments.data.datasource

import com.example.moments.data.api.ListApiService
import com.example.moments.data.model.ListItem

class RemoteDataSource(private val listApiService: ListApiService) : DataSource {
    override suspend fun fetchList(): List<ListItem> {
        return listApiService.getList()
    }
}