package com.example.moments.data.datasource

import com.example.moments.data.model.ListItem

interface DataSource {
    suspend fun fetchList(): List<ListItem>
}