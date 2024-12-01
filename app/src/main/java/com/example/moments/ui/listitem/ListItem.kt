package com.example.moments.ui.listitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
private const val USER_NAME_COLOR = 0xFF326CB8

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
                color = Color(USER_NAME_COLOR)
            )
            Text(
                text = text,
                fontSize = FONT_SIZE.sp,
                color = Color.Black
            )
            ListItemRow(pictures)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 32.dp, top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "1小时前",
                    fontSize = 12.sp
                )
                Box(
                    modifier = Modifier
                        .size(width = 30.dp, height = 18.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFFE5E5E5))
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(4.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Color(0xFF5b6a92))
                        )
                        Box(
                            modifier = Modifier
                                .size(4.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Color(0xFF5b6a92))
                        )
                    }
                }
            }
        }
    }
}

private const val TEST_PIC = "http://localhost:3022/static/avatar/avatar_01.png"
private const val TEST_USER_NAME = "Lilian"
private const val TEST_TEXT = "test for only texts"

@Preview(showBackground = true)
@Composable
fun PreviewListItem() {
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