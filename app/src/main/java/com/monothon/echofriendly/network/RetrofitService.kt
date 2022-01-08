package com.monothon.echofriendly.network

import com.monothon.echofriendly.data.User
import com.monothon.echofriendly.data.response.ChallengeListResponse
import com.monothon.echofriendly.data.response.ResponseData
import com.monothon.echofriendly.data.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

/**
 * Created by Yeji on 2022/01/08.
 */
interface RetrofitService {
    @GET("/api/challenge/all")
    suspend fun getChallengeList(): Response<ResponseData<ChallengeListResponse>>

    @GET("/api/auth/login")
    suspend fun getUserId(
        @Body user: User
    ): Response<ResponseData<UserResponse>>
}