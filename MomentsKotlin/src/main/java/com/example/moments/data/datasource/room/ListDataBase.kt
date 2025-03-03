package com.example.moments.data.datasource.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moments.data.model.ListItem

@Database(entities = [ListItem::class], version = 1)
@TypeConverters(ListConverters::class)
abstract class ListDataBase : RoomDatabase() {
    abstract fun listItemDao(): ListItemDao

    companion object {
        @Volatile
        private var INSTANCE: ListDataBase? = null

        fun getDatabase(context: Context): ListDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ListDataBase::class.java,
                    "list_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}