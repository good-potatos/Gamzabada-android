package com.takeapotato.app.feature.product.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.takeapotato.core.ui.component.GamzaTopBar
import kotlin.random.Random

@Composable
fun ProductListRoute(
    modifier: Modifier = Modifier,
//    viewModel: ForYouViewModel = hiltViewModel()
) {
    ProductListScreen(
        modifier = modifier,
    )
}

@Composable
fun ProductListScreen(
    modifier: Modifier,
) {
    Scaffold(
        topBar = {
            GamzaTopBar(title = "Test")
        },
    ) { innerPadding ->
        val list = listOf<String>("", "", "", "", "")
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {

            items(10) {
                TestItem()
            }
        }
    }

}

@Composable
fun TestItem() {
    Column(Modifier.fillMaxWidth()) {
        Box(Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(Color.Red))
        Spacer(modifier = Modifier.height(9.5.dp))
        val random = Random.nextInt(30)
        Text("나롱이의 라이언 나롱이의 라이언나롱이의 라이언나롱이의 라이언나롱이의라이언나롱이의라이언나롱이의라이언나롱이의라이언나롱이의라이언나롱이의 라이언".substring(0, random))
        Text("현재가격 1,000원")
        Text("19일 4시간 26분 남음")
    }
}