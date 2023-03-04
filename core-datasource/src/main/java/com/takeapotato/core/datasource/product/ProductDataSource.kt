package com.takeapotato.core.datasource.product

import com.takeapotato.core.datasource.product.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductDataSource {

    fun getProduct(): Flow<ProductEntity>
    fun getAllProductList(offset: Int): Flow<List<ProductEntity>>
}