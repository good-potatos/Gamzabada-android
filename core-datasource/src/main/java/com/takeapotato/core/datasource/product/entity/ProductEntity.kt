package com.takeapotato.core.datasource.product.entity

import com.google.gson.annotations.SerializedName

data class ProductEntity(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("thumbnailUrl") val thumbnailUrl: String?,
    @SerializedName("nowBidPrice") val nowBidPrice: Int?,
    @SerializedName("bidEndTime") val bidEndTime: String?,
)