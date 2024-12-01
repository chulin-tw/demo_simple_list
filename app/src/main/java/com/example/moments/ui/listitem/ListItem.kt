package com.example.moments.ui.listitem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
private const val NAME_FONT_SIZE = 12

@Composable
fun ListItem(
    avatar: String,
    userName: String,
    text: String,
    pictures: List<String>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
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
            modifier = Modifier.offset(x = INFO_OFFSET_X.dp)
        ) {
            Text(
                text = userName,
                fontSize = NAME_FONT_SIZE.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = text,
                fontSize = ROUND_CORNER_SHAPE.sp
            )
            ListItemRow(pictures)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewListItem() {
    ListItem(
        avatar = "http://localhost:3022/static/avatar/avatar_01.png",
        userName = "Lilian",
        text = "test for only texts",
        pictures = listOf(
            "http://localhost:3022/static/avatar/avatar_01.png",
            "http://localhost:3022/static/avatar/avatar_01.png",
            "http://localhost:3022/static/avatar/avatar_01.png",
            "http://localhost:3022/static/avatar/avatar_01.png",
        )
    )
}