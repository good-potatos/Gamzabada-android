package com.takeapotato.app.feature.main

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.takeapotato.core.ui.component.GamzaTopBar
import com.takeapotato.core.ui.component.ProductItem
import com.takeapotato.core.ui.component.TagBadge
import com.takeapotato.core.ui.theme.Gray700
import com.takeapotato.core.ui.theme.Gray900
import com.takeapotato.core.ui.theme.White
import com.takeapotato.core.ui.util.dpToSp
import com.takeapotato.core.ui.util.isLastItemVisible
import com.takeapotato.core.ui.util.rememberScrollContext
import com.takeapotato.core.ui.util.toColor
import com.takeapotato.feature.main.R

@Composable
fun MainRoute(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {

    val uiState: MainViewScreenUiState by viewModel.uiState.collectAsState()
    Log.e("Aa", "$uiState")

    MainScreen(
        modifier = modifier,
        uiState = uiState.viewState,
        onScrollEndReach = {
            viewModel.onScrollEndReach()
        }
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    modifier: Modifier,
    uiState: MainViewUiState,
    onScrollEndReach: () -> Unit,
) {
    Scaffold(
        topBar = {
            GamzaTopBar(title = "Test")
        },
    ) { innerPadding ->
        val listState = rememberLazyListState()

        val scrollContext = rememberScrollContext(listState)
        LazyColumn(
            state = listState,
            modifier = modifier.padding(innerPadding)
        ) {

            item {
                TopBanner()
            }

            when (uiState) {
                is MainViewUiState.Success -> {
                    item {
                        CategoryList(
                            categoryList = listOf(
                                CategoryModel(
                                    "https://picsum.photos/40",
                                    "덕질상품"
                                ),
                                CategoryModel(
                                    "https://picsum.photos/40",
                                    "한정판"
                                ),
                                CategoryModel(
                                    "https://picsum.photos/40",
                                    "명품"
                                ),
                                CategoryModel(
                                    "https://picsum.photos/40",
                                    "예술품"
                                )
                            )
                        )
                    }
                    item {
                        SubBanner()
                    }
                    item {
                        ProductTitle("sticky")
                    }
                    stickyHeader {
                        FilterHeader()
                    }
                    items(uiState.allProducts) {
                        Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 28.dp)) {
                            val firstItem = it.first
                            val secondItem = it.second
                            Box(modifier.weight(1f)) {
                                ProductItem(
                                    onClick = { },
                                    title = firstItem.title,
                                    imageUrl = firstItem.thumbnailUrl,
                                    remainTime = firstItem.remainTime,
                                    price = firstItem.currentPrice,
                                    isLike = firstItem.isLike,
                                    onLikeClick = {

                                    }
                                )
                            }
                            Spacer(modifier = Modifier.size(12.dp))
                            Box(modifier.weight(1f)) {
                                secondItem?.let {
                                    ProductItem(
                                        onClick = { },
                                        title = secondItem.title,
                                        imageUrl = secondItem.thumbnailUrl,
                                        remainTime = secondItem.remainTime,
                                        price = secondItem.currentPrice,
                                        isLike = secondItem.isLike,
                                        onLikeClick = {
                                        }
                                    )
                                }
                            }
                        }

                    }
                }

                is MainViewUiState.Loading -> {

                }

                is MainViewUiState.Error -> {

                }
            }
        }

        if (scrollContext.isBottom && scrollContext.isTop.not() && uiState is MainViewUiState.Success) {
            onScrollEndReach()
        }

    }
}


@Composable
fun TopBanner() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.Gray)
    )
}

@Composable
fun SubBanner() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.Yellow)
    )
}

@Composable
fun MainProductList(productList: ProductList) {
    Column {
        ProductTitle(productList.title, {})
        Spacer(modifier = Modifier.height(16.dp))
        ProductRowList(productList.products)
        Spacer(Modifier.height(40.dp))
    }

}

@Composable
private fun CategoryList(categoryList: List<CategoryModel>) {
    Row(modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp)) {
        for (categoryItem in categoryList) {
            Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
                CategoryButton(category = categoryItem)
            }
        }
    }

    Spacer(modifier = Modifier.height(40.dp))
}

@Composable
private fun CategoryButton(category: CategoryModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(category.categoryImageUrl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(40.dp),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = category.categoryName,
            style = TextStyle(
                color = Gray700,
                fontSize = dpToSp(dp = 12.dp),
                lineHeight = dpToSp(dp = 14.4.dp),
                fontWeight = Normal
            )
        )
    }
}

@Composable
private fun ProductTitle(title: String, onClick: (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            style = TextStyle(
                color = Gray900,
                fontSize = dpToSp(dp = 20.dp),
                lineHeight = dpToSp(dp = 27.dp),
                fontWeight = SemiBold
            )
        )
        if (onClick != null) {
            Icon(
                modifier = Modifier.clickable { onClick() },
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = "더보기"
            )
            Spacer(modifier = Modifier.size(16.dp))
        }

    }

}

@Composable
private fun ProductRowList(products: List<ProductModel>) {
    var isLike by remember { mutableStateOf(false) }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(products) {
            Box(Modifier.width(152.dp)) {
                ProductItem(
                    onClick = {},
                    title = it.title,
                    imageUrl = "https://picsum.photos/200?$it",
                    price = it.currentPrice,
                    remainTime = it.remainTime,
                    isLike = it.isLike,
                    titleMaxLine = 1,
                    onLikeClick = { like ->
                        isLike = like
                    },
                    tagBadge = {
                        it.tagBadgeModel?.let {
                            TagBadge(text = it.text, color = it.color.toColor())
                        }
                    }
                )
            }

        }
    }
}

@Composable
fun FilterHeader() {
    Row(
        modifier = Modifier
            .background(White)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "입찰 가능한 상품만 보기",
            style = TextStyle(
                color = Gray900,
                fontSize = dpToSp(dp = 13.dp),
                lineHeight = dpToSp(dp = 15.6.dp),
                fontWeight = Normal
            )
        )

        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.ic_arrow_cross),
            contentDescription = null
        )
        Text(
            text = "최신순",
            style = TextStyle(
                color = Gray900,
                fontSize = dpToSp(dp = 13.dp),
                lineHeight = dpToSp(dp = 15.6.dp),
                fontWeight = Medium
            )
        )
    }
}


// 아래 모델은 임시

data class ProductList(
    val title: String,
    val products: List<ProductModel>
)

data class ProductModel(
    val title: String,
    val thumbnailUrl: String,
    val currentPrice: Int,
    val remainTime: String,
    val isLike: Boolean,
    val onSale: Boolean,
    val tagBadgeModel: TagBadgeModel?,
)

data class TagBadgeModel(
    val text: String,
    val color: String,
)

data class CategoryModel(
    val categoryImageUrl: String,
    val categoryName: String,
)