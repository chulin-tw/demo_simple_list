package com.example.moments.data.datasource

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.moments.data.model.ListItem
import com.google.gson.Gson
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class LocalDataSource(private val context: Context) : DataSource {
    override suspend fun fetchList(): List<ListItem> {
        return fetchListFromDataStore()
    }

    suspend fun saveListToDataStore(listItems: List<ListItem>) {
        val listJson = Gson().toJson(listItems)
        context.dataStore.edit { preferences ->
            preferences[LIST_KEY] = listJson
        }
    }

    private suspend fun fetchListFromDataStore(): List<ListItem> {
        val listJson = context.dataStore.data
            .map { preferences -> preferences[LIST_KEY] ?: "[]" }
            .first()
        return Gson().fromJson(listJson, Array<ListItem>::class.java).toList()
    }
}