package com.example.simplelist.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplelist.R
import com.example.simplelist.ui.SimpleListApp
import com.example.simplelist.ui.theme.SimpleListTheme

@Composable
fun ListItem(title: String, description: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Column {
        Text(
            text = title
        )
        Text(
            text = description
        )
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Companion.Fit,
            modifier = Modifier.Companion.size(200.dp)
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