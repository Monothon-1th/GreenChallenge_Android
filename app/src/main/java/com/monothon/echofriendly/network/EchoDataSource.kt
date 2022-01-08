package com.monothon.echofriendly.network

import com.monothon.echofriendly.data.User

/**
 * Created by Yeji on 2022/01/08.
 */
class EchoDataSource {
    private val retrofitService = try {
        RetrofitClient.getInstance().create(RetrofitService::class.java)
    } catch (e: Exception) {
        null
    }

    suspend fun getUserId(user: User) = retrofitService?.getUserId(user)

    suspend fun getChallengeList() = retrofitService?.getChallengeList()
}