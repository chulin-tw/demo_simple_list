package com.example.moments.ui.momentsheader

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moments.R

private const val HEADER_HEIGHT = 0.25f
private const val NAME_FONT_SIZE = 24
private const val INFO_OFFSET_X = -24
private const val INFO_OFFSET_Y = 24
private const val NAME_PADDING = 8
private const val ROUND_CORNER_SHAPE = 8
private const val AVATAR_SIZE = 90

@Composable
fun MomentsHeader(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(HEADER_HEIGHT)
        ) {
            Image(
                painter = painterResource(id = R.drawable.default_background),
                contentDescription = stringResource(R.string.default_background_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = INFO_OFFSET_X.dp, y = INFO_OFFSET_Y.dp)
                    .align(Alignment.BottomEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(R.string.default_user_name),
                    color = Color.White,
                    fontSize = NAME_FONT_SIZE.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(end = NAME_PADDING.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.default_avatar),
                    contentDescription = stringResource(R.string.default_avatar_description),
                    modifier = Modifier
                        .size(AVATAR_SIZE.dp)
                        .clip(RoundedCornerShape(ROUND_CORNER_SHAPE.dp))
                )
            }
        }
    }
}