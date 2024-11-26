package com.example.simplelist.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simplelist.R
import com.example.simplelist.ui.list.ListViewModel

@Composable
fun SimpleListApp(
    viewModel: ListViewModel = hiltViewModel(), modifier: Modifier = Modifier
) {
//    val listItems = viewModel.list.value
//
//    LazyColumn(modifier = modifier.fillMaxSize()) {
//        items(listItems) { item ->
//            ListItem(
//                title = item.title,
//                description = item.description,
//                image = item.image
//            )
//        }
//    }
//    viewModel.loadItems()
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
        ){
            Image(
                painter = painterResource(id = R.drawable.default_background),
                contentDescription = "default_background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = (-24).dp, y=(24).dp)
                    .align(Alignment.BottomEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ){
                Text(
                    text = "Lilian",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(end = 8.dp))
                Image(
                    painter = painterResource(id = R.drawable.default_avatar),
                    contentDescription = "default_avatar",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

            }
        }

    }

}