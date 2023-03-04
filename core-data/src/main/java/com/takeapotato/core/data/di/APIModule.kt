package com.takeapotato.core.data.di

import com.takeapotato.core.datasource.product.ProductApi
import com.takeapotato.core.datasource.retrofit.RetrofitNetwork
import com.takeapotato.core.datasource.retrofit.RetrofitNetworkImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class APIModule {

    @Provides
    @Singleton
    fun provideRetrofit(retrofit: RetrofitNetworkImpl): RetrofitNetwork = retrofit

    @Provides
    @Singleton
    fun provideProductApi(retrofit: RetrofitNetwork): ProductApi =
        retrofit.buildApi(ProductApi::class.java)
}