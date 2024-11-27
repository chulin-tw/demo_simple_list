package com.example.moments.ui.listitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moments.R

@Composable
fun ListItem(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.default_avatar),
                contentDescription = "user_avatar",
                modifier = Modifier.Companion
                    .size(30.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
        Column(
            modifier = Modifier.offset(x = 38.dp)
        ) {
            Text(
                text = "Lilian",
                fontSize = 12.sp,
                fontWeight = FontWeight.Companion.Bold,
            )
            Text(
                text = "test only text moment",
                fontSize = 8.sp
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewListItem() {
    ListItem()
}