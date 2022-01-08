package com.monothon.echofriendly.data.response

import com.monothon.echofriendly.data.Challenge

/**
 * Created by Yeji on 2022/01/08.
 */
data class ResponseData<T>(
    val status: Int,
    val data: T
)

data class ChallengeListResponse(
    val result: List<Challenge>
)

data class UserResponse(
    val result: Int
)