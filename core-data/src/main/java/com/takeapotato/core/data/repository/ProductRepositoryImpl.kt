package com.takeapotato.core.data.repository

import com.takeapotato.core.data.mapper.product.transform
import com.takeapotato.core.datasource.product.ProductDataSource
import com.takeapotato.core.domain.product.Product
import com.takeapotato.core.domain.product.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val dataSource: ProductDataSource,
) : ProductRepository {

    override fun getProduct(id: Int): Flow<Product> {
        return dataSource.getProduct()
            .map { it.transform() }
    }

}