package com.example.moments.ui.listitem

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.moments.R

@Composable
fun ListItemRow(
    pictures: List<String>,
    modifier: Modifier = Modifier
) {
    pictures.chunked(3).forEach { rowPictures ->
        Row(modifier = modifier) {
            rowPictures.forEach { pic ->
                AsyncImage(
                    model = pic,
                    contentDescription = stringResource(R.string.user_pictures_description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(2.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewListItemRow() {
    ListItemRow(
        pictures = listOf(
            "http://localhost:3022/static/picture/picture_01.png",
            "http://localhost:3022/static/picture/picture_02.png",
            "http://localhost:3022/static/picture/picture_03.png",
        )
    )
}