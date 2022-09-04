package com.takeapotato.core.datasource.product

import com.takeapotato.core.datasource.product.dto.ProductDto
import kotlinx.coroutines.flow.Flow

interface ProductRemote {

    fun getProduct(): Flow<ProductDto>
}