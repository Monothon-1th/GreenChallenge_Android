package com.monothon.echofriendly.network

import com.monothon.echofriendly.data.User
import com.monothon.echofriendly.data.request.JoinRequest
import com.monothon.echofriendly.data.request.UsernameRequest

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

    suspend fun getChallenge(challengeId: Int) = retrofitService?.getChallenge(challengeId)

    suspend fun joinChallenge(userId: Int, challengeId: Int) = retrofitService?.joinChallenge(
        JoinRequest(userId, challengeId)
    )

    suspend fun getUsername(userId: Int) = retrofitService?.getUsername(UsernameRequest(userId))
}