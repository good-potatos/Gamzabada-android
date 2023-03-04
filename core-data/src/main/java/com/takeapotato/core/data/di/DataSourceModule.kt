package com.takeapotato.core.data.di

import com.takeapotato.core.datasource.product.ProductDataSource
import com.takeapotato.core.datasource.product.ProductDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsProductDataSource(
        productDataSource: ProductDataSourceImpl
    ): ProductDataSource


}