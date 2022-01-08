package com.monothon.echofriendly.network

/**
 * Created by Yeji on 2022/01/08.
 */
class EchoDataSource {
    private val retrofitService = try {
        RetrofitClient.getInstance().create(RetrofitService::class.java)
    } catch (e: Exception) {
        null
    }

    suspend fun testRequest() = retrofitService?.testRequest()
}