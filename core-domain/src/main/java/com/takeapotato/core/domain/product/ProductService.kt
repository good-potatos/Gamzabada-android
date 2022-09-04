package com.takeapotato.core.domain.product

import kotlinx.coroutines.flow.Flow

interface ProductService {
    fun getProduct(id: Int): Flow<Product>
}