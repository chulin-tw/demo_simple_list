package com.example.moments

import com.example.moments.data.model.ListItem
import com.example.moments.data.model.MomentInfo
import com.example.moments.data.model.UserInfo

val momentItems = listOf(
    ListItem(
        userInfo = UserInfo(
            username = "Alice",
            avatar = "https://example/avatar/01.png"
        ),
        momentInfo = MomentInfo(
            text = "Hello, Alice",
            picture = listOf("https://example/picture/01.png")
        )
    ),
    ListItem(
        userInfo = UserInfo(
            username = "Bob",
            avatar = "https://example/avatar/02.png"
        ),
        momentInfo = MomentInfo(
            text = "Hello, Bob",
            picture = listOf("https://example/picture/02.png")
        )
    )
)
