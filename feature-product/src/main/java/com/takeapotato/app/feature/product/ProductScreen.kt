package com.takeapotato.app.feature.product

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.takeapotato.core.ui.component.GamzaTopBar

@Composable
fun ProductRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
//    viewModel: ForYouViewModel = hiltViewModel()
) {
    ProductScreen(
        modifier = modifier,
    )
}

@Composable
fun ProductScreen(
    modifier: Modifier,
) {
    Scaffold(
        topBar = {
            GamzaTopBar(title = "Product ")
        },
    ) { innerPadding ->

    }

}