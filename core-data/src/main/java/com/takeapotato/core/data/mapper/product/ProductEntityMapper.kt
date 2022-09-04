package com.takeapotato.core.data.mapper.product

import com.takeapotato.core.datasource.product.entity.ProductEntity
import com.takeapotato.core.domain.product.Product

fun ProductEntity.transform(): Product {
    return Product(
        id = id ?: 0,
        title = title.orEmpty(),
    )
}