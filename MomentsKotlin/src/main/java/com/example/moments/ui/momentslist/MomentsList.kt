package com.example.moments.ui.momentslist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moments.data.model.ListItem
import com.example.moments.ui.listitem.ListItem

private const val LIST_VERTICAL_PADDING = 48
private const val LIST_ITEM_HORIZONTAL_PADDING = 20
private const val LIST_ITEM_VERTICAL_PADDING = 4
private const val DIVIDER_THICKNESS = 0.5

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MomentsList(
    listItems: List<ListItem>,
    isRefreshing: Boolean = false,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    val refreshState = rememberPullToRefreshState()
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        state = refreshState,
        contentAlignment = Alignment.TopStart,
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = LIST_VERTICAL_PADDING.dp
                )
        ) {
            items(listItems) { item ->
                ListItem(
                    avatar = item.userInfo.avatar,
                    userName = item.userInfo.username,
                    text = item.momentInfo.text,
                    pictures = item.momentInfo.picture,
                    modifier = Modifier.padding(
                        horizontal = LIST_ITEM_HORIZONTAL_PADDING.dp,
                        vertical = LIST_ITEM_VERTICAL_PADDING.dp
                    )
                )
                HorizontalDivider(
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .padding(vertical = LIST_ITEM_VERTICAL_PADDING.dp),
                    thickness = DIVIDER_THICKNESS.dp
                )
            }
        }
    }
}