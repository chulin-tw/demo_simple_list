package com.example.moments.data.model

data class ListItem(
    val userInfo: UserInfo,
    val momentInfo: MomentInfo
)

data class UserInfo(
    val username: String,
    val avatar: String
)

data class MomentInfo(
    val text: String,
    val picture: List<String>
)
