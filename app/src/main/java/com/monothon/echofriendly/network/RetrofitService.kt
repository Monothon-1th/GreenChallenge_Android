package com.monothon.echofriendly.network

import retrofit2.Response
import retrofit2.http.*

/**
 * Created by Yeji on 2022/01/08.
 */
interface RetrofitService {
    @POST("ping")
    suspend fun testRequest(): Response<String>
}