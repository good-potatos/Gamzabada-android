package com.takeapotato.core.domain.product

data class Product(
    val id: Int,
    val title: String,
    val thumbnailUrl: String,
    val currentPrice: Int,
    val remainTime: String,
    val isLike: Boolean,
    val onSale: Boolean,
)
