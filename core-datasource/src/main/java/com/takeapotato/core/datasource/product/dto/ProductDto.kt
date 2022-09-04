package com.takeapotato.core.datasource.product.dto

import com.google.gson.annotations.SerializedName
import com.takeapotato.core.datasource.product.entity.ProductEntity

data class ProductDto(
    @SerializedName("data") val data: ProductEntity?,
)