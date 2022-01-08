package com.monothon.echofriendly.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Yeji on 2022/01/08.
 */
data class Challenge(
    val id: Int,
    val title: String,
    val tag: String,
    var participants: Int,
    @SerializedName("image")
    val imageUrl: String
)
