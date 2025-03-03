package com.example.moments.data.datasource.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moments.data.model.ListItem

@Dao
interface ListItemDao {
    @Query("SELECT * FROM listitem")
    suspend fun getAll(): List<ListItem>

    @Insert
    suspend fun insertAll(vararg items: ListItem)
}