package com.example.bolt.ui.otp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class OtpViewModel : ViewModel()
{
    val isLoading : MutableLiveData<Boolean> = MutableLiveData(false)
    var isValidOtp : Boolean = false;
    val isError : MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkOtp(otp :String) : Boolean {
        viewModelScope.launch {
            isValidOtp = false
            isLoading.value = false
            isValidOtp = true
        }
        return isValidOtp
    }



}