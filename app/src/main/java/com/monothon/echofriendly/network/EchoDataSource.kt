package com.monothon.echofriendly.network

import com.monothon.echofriendly.FormFileUtil
import com.monothon.echofriendly.data.User
import com.monothon.echofriendly.data.request.JoinRequest
import com.monothon.echofriendly.data.request.UsernameRequest
import retrofit2.Response
import java.io.File

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

    suspend fun getFeedList() = retrofitService?.getFeedList()

    suspend fun createList(imagePath: String?, category: String, userId: Int, title: String): Response<Unit>? {
        val imagePart = if (imagePath != null) {
            val file = File(imagePath)
            FormFileUtil.getImageBody("file", file)
        } else null

        val categoryPart = FormFileUtil.getBody("category", category)
        val userIdPart = FormFileUtil.getBody("writerId", userId)
        val titlePart = FormFileUtil.getBody("title", title)
        val textPart = FormFileUtil.getBody("text", title)

        return retrofitService?.createList(imagePart, categoryPart, userIdPart, titlePart, textPart)
    }
}