package com.monothon.echofriendly.network

import com.monothon.echofriendly.data.Challenge
import com.monothon.echofriendly.data.Feed
import com.monothon.echofriendly.data.User
import com.monothon.echofriendly.data.request.JoinRequest
import com.monothon.echofriendly.data.request.UsernameRequest
import com.monothon.echofriendly.data.response.ResponseSimpleData
import com.monothon.echofriendly.data.response.ResponseResultData
import com.monothon.echofriendly.data.response.UserIdResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by Yeji on 2022/01/08.
 */
interface RetrofitService {
    @GET("/api/challenge/all")
    suspend fun getChallengeList(): Response<ResponseResultData<List<Challenge>>>

    @POST("/api/auth/login")
    suspend fun getUserId(
        @Body user: User
    ): Response<ResponseSimpleData<UserIdResponse>>

    @GET("/api/challenge/args?")
    suspend fun getChallenge(
        @Query("id") challengeId: Int
    ): Response<ResponseSimpleData<Challenge>>

    @POST("/api/participate/create")
    suspend fun joinChallenge(
        @Body request: JoinRequest
    ): Response<Unit>

    @POST("/api/auth/name")
    suspend fun getUsername(
        @Body request: UsernameRequest
    ): Response<ResponseResultData<String>>

    @GET("/api/list/all")
    suspend fun getFeedList(): Response<ResponseResultData<List<Feed>>>

    @Multipart
    @POST("/api/list/create")
    suspend fun createList(
        @Part image: MultipartBody.Part?,
        @Part category: MultipartBody.Part,
        @Part writerId: MultipartBody.Part,
        @Part title: MultipartBody.Part,
        @Part text: MultipartBody.Part
    ): Response<Unit>
}