package com.example.simplelist.data.datasource

import com.example.simplelist.data.api.ListApiService
import com.example.simplelist.data.model.ListItem
import javax.inject.Inject

class ListDataSource @Inject constructor(private val listApiService: ListApiService) {
    suspend fun fetchList(): Result<List<ListItem>> {
        return try {
            val response = listApiService.getList()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure<List<ListItem>>(e)
        }
    }
}