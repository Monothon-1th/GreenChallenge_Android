package com.monothon.echofriendly.data.response

/**
 * Created by Yeji on 2022/01/08.
 */
data class ResponseResultData<T>(
    val status: Int,
    val data: ResultResponse<T>
)

data class ResponseSimpleData<T>(
    val status: Int,
    val data: T
)

data class ResultResponse<T>(
    val result: T
)

data class UserIdResponse(
    val userId: Int
)