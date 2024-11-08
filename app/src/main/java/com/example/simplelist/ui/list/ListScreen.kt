package com.example.simplelist.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.example.simplelist.ui.SimpleListApp
import com.example.simplelist.ui.theme.SimpleListTheme

@Composable
fun ListItem(title: String, description: String, image: String, modifier: Modifier = Modifier) {
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
fun TextPreview() {
    SimpleListTheme {
        SimpleListApp()
    }
}