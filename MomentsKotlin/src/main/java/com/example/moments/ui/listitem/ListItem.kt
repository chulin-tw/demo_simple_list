package com.example.moments.ui.listitem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.moments.R

private const val AVATAR_SIZE = 30
private const val ROUND_CORNER_SHAPE = 8
private const val INFO_OFFSET_X = 38
private const val FONT_SIZE = 12

@Composable
fun ListItem(
    avatar: String,
    userName: String,
    text: String,
    pictures: List<String>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column {
            AsyncImage(
                model = avatar,
                contentDescription = stringResource(R.string.list_item_user_avatar_description),
                modifier = Modifier
                    .size(AVATAR_SIZE.dp)
                    .clip(RoundedCornerShape(ROUND_CORNER_SHAPE.dp))
            )
        }
        Column(
            modifier = Modifier
                .offset(x = INFO_OFFSET_X.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = userName,
                fontSize = FONT_SIZE.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.username_blue)
            )
            Text(
                text = text,
                fontSize = FONT_SIZE.sp,
                color = Color.Black
            )
            ListItemRow(pictures)
            ListItemBottomRow()
        }
    }
}

private const val TEST_PIC = "http://localhost:3022/static/avatar/avatar_01.png"
private const val TEST_USER_NAME = "Lilian"
private const val TEST_TEXT = "test for only texts"

@Preview(showBackground = true)
@Composable
private fun PreviewListItem() {
    ListItem(
        avatar = TEST_PIC,
        userName = TEST_USER_NAME,
        text = TEST_TEXT,
        pictures = listOf(
            TEST_PIC,
            TEST_PIC,
            TEST_PIC,
            TEST_PIC,
        )
    )
}