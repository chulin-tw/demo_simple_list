package com.example.moments.data.datasource

import android.content.Context
import com.example.moments.data.api.ListApiService
import com.example.moments.data.model.ListItem

class ListDataSource(
    listApiService: ListApiService,
    context: Context
) : DataSource {
    private val remoteListDataSource: RemoteDataSource = RemoteDataSource(listApiService)
    private val localListDataSource: LocalDataSource = LocalDataSource(context)

    override suspend fun fetchList(): List<ListItem> {
        return try {
            val list = remoteListDataSource.fetchList()
            localListDataSource.saveListToDataStore(list)
            list
        } catch (e: Exception) {
            localListDataSource.fetchList()
        }
    }
}