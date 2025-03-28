package com.example.moments.data.repository

import com.example.moments.data.datasource.ListDataSource
import com.example.moments.data.model.ListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ListRepository(private val listDataSource: ListDataSource) {
    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
    fun getList(): List<ListItem> {
            val res = executorService.submit<List<ListItem>> {
                runBlocking {
                    listDataSource.fetchList()
                }
            }
           return res.get()
    }
}
