package com.takeapotato.core.data.di

import com.takeapotato.core.datasource.product.ProductRemote
import com.takeapotato.core.datasource.product.ProductRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataModule {

    @Binds
    fun bindsProductRemote(
        productRemote: ProductRemoteImpl
    ): ProductRemote


}