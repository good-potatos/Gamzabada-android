package com.takeapotato.core.datasource.retrofit

interface RetrofitNetwork {
    fun <T> buildApi(apiClass: Class<T>): T
}
