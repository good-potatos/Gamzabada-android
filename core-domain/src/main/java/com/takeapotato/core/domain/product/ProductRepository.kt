package com.takeapotato.core.domain.product

import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProduct(id: Int): Flow<Product>
}