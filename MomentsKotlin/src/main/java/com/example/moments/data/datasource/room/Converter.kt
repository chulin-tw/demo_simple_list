package com.example.moments.data.datasource.room

import androidx.room.TypeConverter

class ListConverters {
    @TypeConverter
    fun fromString(value: String): List<String> {
        if (value.isEmpty()) return emptyList()
        return value.split(",")
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString(",")
    }
}