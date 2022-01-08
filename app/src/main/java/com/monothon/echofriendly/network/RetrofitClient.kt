package com.monothon.echofriendly.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Yeji on 2022/01/08.
 */
object RetrofitClient {
    private const val BASE_URL = "http://ec2-13-124-161-129.ap-northeast-2.compute.amazonaws.com:8080"
    private val instance: Retrofit? = null

    fun getInstance(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return instance ?: Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}