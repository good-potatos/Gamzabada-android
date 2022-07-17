package com.takeapotato.app.feature.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.takeapotato.core.ui.component.GamzaTopBar

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
//    viewModel: ForYouViewModel = hiltViewModel()
) {
    SearchScreen(
        modifier = modifier,
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier,
) {
//    Scaffold(
//        topBar = {
//            GamzaTopBar(title = "Test")
//        },
//    ) { innerPadding ->
//        LazyColumn {
//
//        }
//
//    }

}