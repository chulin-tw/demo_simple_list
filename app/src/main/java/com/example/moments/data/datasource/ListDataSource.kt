package com.example.moments.data.datasource

import com.example.moments.data.api.ListApiService
import com.example.moments.data.model.ListItem
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