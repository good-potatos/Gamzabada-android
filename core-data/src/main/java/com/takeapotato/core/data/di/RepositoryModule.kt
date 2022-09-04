package com.takeapotato.core.data.di

import com.takeapotato.core.data.repository.ProductRepositoryImpl
import com.takeapotato.core.domain.product.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsProductRepository(
        productRepository: ProductRepositoryImpl
    ): ProductRepository


}