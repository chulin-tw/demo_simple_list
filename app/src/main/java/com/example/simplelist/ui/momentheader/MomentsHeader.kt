package com.example.simplelist.ui.momentheader

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplelist.R

@Composable
fun MomentsHeader(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.default_background),
                contentDescription = "default_background",
                contentScale = ContentScale.Companion.Crop,
                modifier = Modifier.Companion
                    .fillMaxSize()
            )
            Row(
                modifier = Modifier.Companion
                    .fillMaxWidth()
                    .offset(x = (-24).dp, y = (24).dp)
                    .align(Alignment.Companion.BottomEnd),
                verticalAlignment = Alignment.Companion.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Lilian",
                    color = Color.Companion.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Companion.Bold,
                    modifier = modifier.padding(end = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.default_avatar),
                    contentDescription = "default_avatar",
                    modifier = Modifier.Companion
                        .size(90.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}