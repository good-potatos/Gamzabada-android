package com.takeapotato.core.datasource.product.dto

import com.google.gson.annotations.SerializedName
import com.takeapotato.core.datasource.product.entity.ProductEntity

data class ProductDto(
    @SerializedName("content") val data: ProductEntity?,
    @SerializedName("totalPages") val totalPages: Int = 0,
    @SerializedName("last") val last: Boolean = false ,
)