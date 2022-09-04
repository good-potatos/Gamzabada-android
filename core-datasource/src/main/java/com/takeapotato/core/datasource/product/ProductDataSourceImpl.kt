package com.takeapotato.core.datasource.product

import com.takeapotato.core.datasource.product.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor(
    private val remote: ProductRemote
): ProductDataSource {

    override fun getProduct(): Flow<ProductEntity> {
        return remote.getProduct().map { it.data!! }
    }


}