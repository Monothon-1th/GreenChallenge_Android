package com.monothon.echofriendly.data.request

/**
 * Created by Yeji on 2022/01/09.
 */
data class JoinRequest(
    val userId: Int,
    val challengeId: Int
)

data class UsernameRequest(
    val userId: Int
)