package com.example.moments.ui.listitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val TIME_FONT_SIZE = 12
private const val ROW_END_PADDING = 32
private const val ROW_TOP_PADDING = 8
private const val ACTION_BOX_WIDTH = 30
private const val ACTION_BOX_HEIGHT = 18
private const val ACTION_BOX_CORNER_SHAPE = 4
private const val ACTION_BOX_SPACE = 4
private const val ACTION_BOX_COLOR = 0xFFE5E5E5
private const val ACTION_CIRCLE_SHAPE = 2
private const val ACTION_CIRCLE_COLOR = 0xFF5b6a92

@Composable
fun ListItemBottomRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = ROW_END_PADDING.dp, top = ROW_TOP_PADDING.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "1小时前",
            fontSize = TIME_FONT_SIZE.sp
        )
        ActionButton()
    }
}

@Composable
private fun ActionButton(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .size(width = ACTION_BOX_WIDTH.dp, height = ACTION_BOX_HEIGHT.dp)
            .clip(RoundedCornerShape(ACTION_BOX_CORNER_SHAPE.dp))
            .background(Color(ACTION_BOX_COLOR))
            .padding(ACTION_BOX_CORNER_SHAPE.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ActionCircle()
        Spacer(modifier = Modifier.size(ACTION_BOX_SPACE.dp))
        ActionCircle()
    }

}

@Composable
private fun ActionCircle(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(ACTION_BOX_CORNER_SHAPE.dp)
            .clip(RoundedCornerShape(ACTION_CIRCLE_SHAPE.dp))
            .background(Color(ACTION_CIRCLE_COLOR))
    )
}