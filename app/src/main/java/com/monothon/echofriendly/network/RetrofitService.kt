package com.monothon.echofriendly.network

import com.monothon.echofriendly.data.response.ChallengeListResponse
import com.monothon.echofriendly.data.response.ResponseData
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Yeji on 2022/01/08.
 */
interface RetrofitService {
    @GET
    suspend fun getChallengeList(): Response<ResponseData<ChallengeListResponse>>
}