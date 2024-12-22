package com.example.moments.data.datasource

import com.example.moments.data.api.ListApiClient
import com.example.moments.data.model.ListItem

class ListDataSource(private val listApiClient: ListApiClient) {
     fun fetchList(): Result<List<ListItem>> {
        return try {
            val list = listApiClient.getList()
            if (list != null) {
                Result.success(list)
            } else {
                Result.failure(Exception("Failed to fetch list: null response"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
