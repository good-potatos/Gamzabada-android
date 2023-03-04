package com.takeapotato.core.ui.util

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember



val LazyListState.isFirstItemVisible: Boolean
    get() = firstVisibleItemIndex == 0

val LazyListState.isLastItemVisible: Boolean
    get() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1

data class ScrollContext(
    val isTop: Boolean,
    val isBottom: Boolean,
)
@Composable
fun rememberScrollContext(listState: LazyListState): ScrollContext {
    val scrollContext by remember {
        derivedStateOf {
            ScrollContext(
                isTop = listState.isFirstItemVisible,
                isBottom = listState.isLastItemVisible
            )
        }
    }
    return scrollContext
}