package com.monothon.echofriendly.network

import com.monothon.echofriendly.data.User
import com.monothon.echofriendly.data.response.ResponseData
import com.monothon.echofriendly.data.response.UserResponse
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by Yeji on 2022/01/08.
 */
interface RetrofitService {
    @POST("/api/auth/signup")
    suspend fun testRequest(
        @Body user: User
    ): Response<ResponseData<UserResponse>>
}