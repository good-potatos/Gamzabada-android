package com.takeapotato.core.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GamzaTopBar(
    title: String,
) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        Text(title)
    }
}