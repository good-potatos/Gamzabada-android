package com.takeapotato.core.ui.util

import android.graphics.Color.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import java.text.DecimalFormat

@Composable
fun dpToSp(dp: Dp) = with(LocalDensity.current) { dp.toSp() }

fun Number.toDecimal(): String {
    return DecimalFormat("#,###").format(this)
}

fun String.toColor(): Color {
    return runCatching {
        Color(parseColor(this))
    }.getOrElse { Color(0x00000000) }
}
