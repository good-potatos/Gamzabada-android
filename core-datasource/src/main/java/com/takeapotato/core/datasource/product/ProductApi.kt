package com.takeapotato.core.datasource.product

import com.takeapotato.core.datasource.product.dto.ProductDto
import retrofit2.http.GET

interface ProductApi {

    @GET("/gamzabada-dev/products")
    suspend fun getProducts(

    ): ProductDto
}
