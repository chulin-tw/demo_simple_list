package com.example.moments.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Embedded val userInfo: UserInfo,
    @Embedded val momentInfo: MomentInfo
)

data class UserInfo(
    val username: String,
    val avatar: String
)

data class MomentInfo(
    val text: String,
    val picture: List<String>
)
