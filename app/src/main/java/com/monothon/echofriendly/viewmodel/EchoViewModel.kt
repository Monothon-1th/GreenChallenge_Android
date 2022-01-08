package com.monothon.echofriendly.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monothon.echofriendly.RESPONSE_CODE_OK
import com.monothon.echofriendly.data.Challenge
import com.monothon.echofriendly.network.EchoDataSource
import kotlinx.coroutines.launch

/**
 * Created by Yeji on 2022/01/08.
 */
class EchoViewModel : ViewModel() {
    private val dataSource = EchoDataSource()

    val challengeList = MutableLiveData<List<Challenge>>()

    fun getChallengeList() = viewModelScope.launch {
        val response = dataSource.getChallengeList()
        if (response?.code() == RESPONSE_CODE_OK) {
            challengeList.value = response.body()?.data?.result
        }
    }
}