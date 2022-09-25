package com.takeapotato.app.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.takeapotato.core.ui.component.GamzaTopBar
import com.takeapotato.core.ui.component.ProductItem
import com.takeapotato.core.ui.component.TagBadge
import com.takeapotato.core.ui.theme.Gray900

@Composable
fun MainRoute(
    modifier: Modifier = Modifier,
//    viewModel: ForYouViewModel = hiltViewModel()
) {
    MainScreen(
        modifier = modifier,
    )
}

@Composable
fun MainScreen(
    modifier: Modifier,
) {
    Scaffold(
        topBar = {
            GamzaTopBar(title = "Test")
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.padding(innerPadding)
        ) {
            item {
                TopBanner()
            }

            item {
                MainProductList()
            }


        }
    }
}

@Composable
fun TopBanner() {

    Box(
        Modifier
            .fillMaxWidth()
            .height(220.dp)
            .background(Color.Gray)
    )
}

@Composable
fun MainProductList() {
    Column {
        ProductTitle("인기있는 상품들")
        ProductRowList()
    }

}

@Composable
private fun ProductTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
        style = TextStyle(
            color = Gray900,
            fontSize = 20.sp,
            lineHeight = 27.sp,
            fontWeight = SemiBold
        )
    )
}

@Composable
private fun ProductRowList() {
    var isLike by remember { mutableStateOf(false) }

    LazyRow(
        contentPadding = PaddingValues(20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {


        items(6) {
            Box(Modifier.width(152.dp)) {
                ProductItem(
                    onClick = {},
                    title = "나롱이의 춘식이나롱이의 춘식이나롱이의 춘식이나롱이의 춘식이",
                    imageUrl = "https://picsum.photos/200?$it",
                    price = 14000,
                    remainTime = "14일 4시간 26분 남음",
                    isLike = isLike,
                    titleMaxLine = 2,
                    onLikeClick = {like ->
                        isLike = like
                    },
                    tagBadge = {
                        TagBadge(text = "예약완료", color = Color.Black)
                    }
                )
            }

        }
    }
}
