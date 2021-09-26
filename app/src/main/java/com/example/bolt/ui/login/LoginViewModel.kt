package com.example.bolt.ui.login

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bolt.repositories.DataStoreRepository
import com.example.bolt.repositories.MainRepository
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: MainRepository,
    private val dataStoreRepository: DataStoreRepository
): ViewModel() {
    val isLoading : MutableLiveData<Boolean> = MutableLiveData(false)
    val isError : MutableLiveData<Boolean> = MutableLiveData(false)
    val isSuccess : MutableLiveData<Boolean> = MutableLiveData(false)

    fun login(phoneNumber : String , activity : Activity){

        isLoading.value = true
        viewModelScope.launch {
//            val firebaseAuth = Firebase.auth
//            val firebaseAuthSettings = firebaseAuth.firebaseAuthSettings
//            // firebaseAuthSettings.setAutoRetrievedSmsCodeForPhoneNumber(phoneNumber, smsCode)
//            val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
//                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
//
//                    Log.d("auth success","auth success")
//                }
//
//                override fun onVerificationFailed(p0: FirebaseException) {
//                    Log.d("fail auth ",p0.toString())
//                }
//
//                override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
//                    super.onCodeSent(p0, p1)
//
//                }
//            }
//            val options = PhoneAuthOptions.newBuilder(firebaseAuth)
//                .setPhoneNumber(phoneNumber)
//                .setTimeout(10L, TimeUnit.SECONDS)
//                .setActivity(activity)
//                .setCallbacks(callbacks)
//                .build()
//            PhoneAuthProvider.verifyPhoneNumber(options)



        dataStoreRepository.saveLoginValue(true)



            isLoading.value = false
            isError.value = false
            isSuccess.value = true

        }

    }


}