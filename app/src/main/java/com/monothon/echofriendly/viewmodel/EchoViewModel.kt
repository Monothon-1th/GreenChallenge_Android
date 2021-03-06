package com.monothon.echofriendly.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monothon.echofriendly.RESPONSE_CODE_OK
import com.monothon.echofriendly.data.Challenge
import com.monothon.echofriendly.data.Feed
import com.monothon.echofriendly.data.User
import com.monothon.echofriendly.network.EchoDataSource
import kotlinx.coroutines.launch

/**
 * Created by Yeji on 2022/01/08.
 */
class EchoViewModel : ViewModel() {
    private val dataSource = EchoDataSource()

    val challengeList = MutableLiveData<List<Challenge>>()
    val challenge = MutableLiveData<Challenge>()
    val joinSuccess = MutableLiveData(false)
    val createSuccess = MutableLiveData(false)
    val username = MutableLiveData<String>()
    val feedList = MutableLiveData<List<Feed>>()
    var userId: Int = 0
        private set

    fun getUserId() = viewModelScope.launch {
        val response = dataSource.getUserId(User("user1", "1234"))
        if (response?.code() == RESPONSE_CODE_OK) {
            userId = response.body()?.data?.userId ?: 0
        }
    }

    fun getChallengeList() = viewModelScope.launch {
        val response = dataSource.getChallengeList()
        if (response?.code() == RESPONSE_CODE_OK) {
            challengeList.value = response.body()?.data?.result
        }
    }

    fun getChallenge(challengeId: Int) = viewModelScope.launch {
        val response = dataSource.getChallenge(challengeId)
        if (response?.code() == RESPONSE_CODE_OK) {
            challenge.value = response.body()?.data
        }
    }

    fun joinChallenge(challengeId: Int) = viewModelScope.launch {
        val response = dataSource.joinChallenge(userId, challengeId)
        if (response?.code() == RESPONSE_CODE_OK) {
            joinSuccess.value = true
        }
    }

    fun getUsername() = viewModelScope.launch {
        val response = dataSource.getUsername(userId)
        if (response?.code() == RESPONSE_CODE_OK) {
            username.value = response.body()?.data?.result
            Log.i("ellie", "username = ${username.value}")
        }
    }

    fun getFeedList() = viewModelScope.launch {
        val response = dataSource.getFeedList()
        if (response?.code() == RESPONSE_CODE_OK) {
            feedList.value = response.body()?.data?.result
            Log.i("ellie", "feed list = ${feedList.value}")
        }
    }

    fun createList(imagePath: String?, category: String, title: String) = viewModelScope.launch {
        val response = dataSource.createList(imagePath, category, userId, title)
        if (response?.code() == RESPONSE_CODE_OK) {
            createSuccess.value = true
        }
    }
}