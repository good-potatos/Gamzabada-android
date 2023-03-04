package com.takeapotato.core.datasource.retrofit

import com.takeapotato.core.datasource.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitNetworkImpl @Inject constructor(): RetrofitNetwork {

    private val baseUrl = "http://api-test.gamzabada.com:8080"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(
            if (BuildConfig.DEBUG) {
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    })
                    .build()
            } else {
                OkHttpClient.Builder().build()
            }
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    override fun <T> buildApi(apiClass: Class<T>): T {
        return retrofit.create(apiClass)
    }

}