package com.takeapotato.app.feature.product.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.takeapotato.core.domain.product.Product
import com.takeapotato.core.ui.component.GamzaTopBar
import kotlin.random.Random

@Composable
fun ProductListRoute(
    modifier: Modifier = Modifier,
    navigateToProduct: (String) -> Unit,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val uiState: ProductListScreenUiState by viewModel.uiState.collectAsState()

    ProductListScreen(
        modifier = modifier,
        productState = uiState.productsState,
        navigateToProduct = navigateToProduct
    )
}

@Composable
fun ProductListScreen(
    modifier: Modifier,
    productState: ProductsUiState,
    navigateToProduct: (String) -> Unit,
) {
    Scaffold(
        topBar = {
            GamzaTopBar(title = "Product List")
        },
    ) { innerPadding ->

        when (productState) {
            ProductsUiState.Loading -> {
            }
            ProductsUiState.Error -> {

            }
            is ProductsUiState.Success -> {
                val list = productState.products
                LazyVerticalGrid(columns = GridCells.Fixed(2),
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    items(list) {
                        TestItem(navigateToProduct, it.title)
                    }
                }
            }
        }


    }

}

@Composable
fun TestItem(navigateToProduct: (String) -> Unit, title: String) {
    Column(Modifier.fillMaxWidth()) {
        Box(Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(Color.Red)
            .clickable {
                navigateToProduct("1")
            })
        Spacer(modifier = Modifier.height(9.5.dp))
        val random = Random.nextInt(30)
        Text(title)
        Text("현재가격 1,000원")
        Text("19일 4시간 26분 남음")
    }
}