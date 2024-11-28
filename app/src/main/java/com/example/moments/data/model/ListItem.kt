package com.example.moments.data.model

import kotlinx.serialization.Serializable


@Serializable
data class ListItem(
    val userInfo: UserInfo,
    val momentInfo: MomentInfo
)

@Serializable
data class UserInfo(
    val username: String,
    val avatar: String
)

@Serializable
data class MomentInfo(
    val text: String,
    val picture: List<String>?
)
