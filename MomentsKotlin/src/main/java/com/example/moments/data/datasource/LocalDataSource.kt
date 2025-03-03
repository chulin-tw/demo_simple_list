package com.example.moments.data.datasource

import android.content.Context
import com.example.moments.data.datasource.room.ListDataBase
import com.example.moments.data.model.ListItem

class LocalDataSource(private val context: Context) : DataSource {
    private val listItemDao = ListDataBase.getDatabase(context).listItemDao()

    override suspend fun fetchList(): List<ListItem> {
        return listItemDao.getAll()
    }

    suspend fun saveListToDataStore(list: List<ListItem>) {
        listItemDao.insertAll(*list.toTypedArray())
    }
}