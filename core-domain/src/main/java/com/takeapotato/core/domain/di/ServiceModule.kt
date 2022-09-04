package com.takeapotato.core.domain.di

import com.takeapotato.core.domain.product.ProductService
import com.takeapotato.core.domain.product.ProductServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ServiceModule {

    @Binds
    fun bindsProductService(
        productService: ProductServiceImpl
    ): ProductService

}