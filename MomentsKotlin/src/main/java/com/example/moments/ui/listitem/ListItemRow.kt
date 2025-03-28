package com.example.moments.ui.listitem

import ListItemFullScreenPager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil3.compose.AsyncImage
import com.example.moments.R

@Composable
fun ListItemRow(
    pictures: List<String>,
    modifier: Modifier = Modifier
) {
    val (isFullScreen, setFullScreen) = remember { mutableStateOf(false) }
    val (initialPage, setInitialPage) = remember { mutableIntStateOf(0) }

    if (isFullScreen) {
        Dialog(
            onDismissRequest = { setFullScreen(false) },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                usePlatformDefaultWidth = false
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                ListItemFullScreenPager(
                    pictures = pictures,
                    initialPage = initialPage,
                    onDismiss = { setFullScreen(false) }
                )
            }
        }
    }

    pictures.chunked(3).forEach { rowPictures ->
        Row(modifier = modifier) {
            rowPictures.forEachIndexed { index, pic ->
                AsyncImage(
                    model = pic,
                    contentDescription = stringResource(R.string.user_pictures_description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(2.dp)
                        .clickable {
                            setInitialPage(index)
                            setFullScreen(true)
                        }
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