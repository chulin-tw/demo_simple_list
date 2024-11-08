package com.example.simplelist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ListItem(
    val image: String,
    val title: String,
    val description: String
)