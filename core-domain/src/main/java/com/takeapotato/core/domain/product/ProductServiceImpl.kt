package com.takeapotato.core.domain.product

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductServiceImpl @Inject constructor(
    private val productServiceRepository: ProductRepository,
): ProductService {
    override fun getProduct(id: Int): Flow<Product> {
        return productServiceRepository.getProduct(id)
    }

}