package com.takeapotato.core.domain.product

import android.util.Log
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductServiceImpl @Inject constructor(
    private val productServiceRepository: ProductRepository,
): ProductService {
    override fun getProduct(id: Int): Flow<Product> {
        return productServiceRepository.getProduct(id)
    }

    override fun getAllProductList(offset: Int): Flow<List<Product>> {
        Log.e("aa", "$offset")
        return productServiceRepository.getAllProductList(offset)
    }

}