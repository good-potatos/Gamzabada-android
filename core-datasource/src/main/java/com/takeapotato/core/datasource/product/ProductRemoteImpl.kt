package com.takeapotato.core.datasource.product

import com.takeapotato.core.datasource.product.dto.ProductDto
import com.takeapotato.core.datasource.product.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRemoteImpl @Inject constructor(
    private val api: ProductApi
) : ProductRemote {
    override fun getProduct(): Flow<ProductDto> {

        // todo retrofit
        return flow {
            emit(api.getProducts())
//            emit(ProductDto(data = ProductEntity(1, "aaa")))
        }
    }
}