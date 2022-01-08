package com.monothon.echofriendly.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Yeji on 2022/01/09.
 */
data class Feed(
    val list: FeedItem,
    val writerName: String,
    @SerializedName("writerImage")
    val writerImageUrl: String
)

data class FeedItem(
    val id: Int,
    val category: String,
    val writerId: Int,
    val title: String,
    val text: String,
    @SerializedName("image")
    val imageUrl: String,
    val createdAt: String,
    val heart: Int,
    val comment: Int
)