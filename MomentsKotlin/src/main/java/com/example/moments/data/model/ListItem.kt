package com.example.moments.data.model

import androidx.annotation.Keep
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
@Keep
data class ListItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Embedded val userInfo: UserInfo,
    @Embedded val momentInfo: MomentInfo
)

@Keep
data class UserInfo(
    val username: String,
    val avatar: String
)

@Keep
data class MomentInfo(
    val text: String,
    val picture: List<String>
)
