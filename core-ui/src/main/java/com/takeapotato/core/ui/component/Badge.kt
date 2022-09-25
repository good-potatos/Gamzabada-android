package com.takeapotato.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.takeapotato.core.ui.theme.Gray900
import com.takeapotato.core.ui.theme.White
import com.takeapotato.core.ui.util.dpToSp


@Composable
fun TagBadge(
    text: String,
    color: Color,
) {
    Box(
        modifier = Modifier.background(color = color, shape = RoundedCornerShape(2.dp))
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(start = 4.dp, end = 4.dp),
            style = TextStyle(
                color = White,
                fontSize = dpToSp(dp = 11.dp),
                lineHeight = dpToSp(dp = 13.2.dp),
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Preview
@Composable
fun TagBadgePreview() {
    TagBadge(text = "예약완료", color = Gray900)
}


