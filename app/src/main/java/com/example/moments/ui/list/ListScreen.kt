package com.example.moments.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage

@Composable
fun MomentList(title: String, description: String, image: String, modifier: Modifier = Modifier) {
    //TODO:update it
    Column {
        Text(
            text = title
        )
        Text(
            text = description
        )
        AsyncImage(
            model = image,
            contentDescription = null,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun MomentPreview() {
    //Todo: update it from MomentList
}