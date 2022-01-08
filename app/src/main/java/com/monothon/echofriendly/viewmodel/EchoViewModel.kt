package com.monothon.echofriendly.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monothon.echofriendly.RESPONSE_CODE_OK
import com.monothon.echofriendly.network.EchoDataSource
import kotlinx.coroutines.launch

/**
 * Created by Yeji on 2022/01/08.
 */
class EchoViewModel : ViewModel() {
    private val dataSource = EchoDataSource()

    private val _testString = MutableLiveData<String>()
    val testString: LiveData<String> = _testString

    fun test() = viewModelScope.launch {
        val response = dataSource.testRequest()
        if (response?.code() == RESPONSE_CODE_OK) {
            _testString.value = response.body()
        }
    }
}