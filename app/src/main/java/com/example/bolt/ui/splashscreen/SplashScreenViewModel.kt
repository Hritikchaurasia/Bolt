package com.example.bolt.ui.splashscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bolt.repositories.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
): ViewModel()  {

    val isDelayComplete : MutableLiveData<Boolean> = MutableLiveData(false)
    var isLoggedIn: Boolean = false

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val readFromDataStore = dataStoreRepository.readLoginValue()
            isLoggedIn = readFromDataStore
            delay(1000)
            isDelayComplete.postValue(true)
        }
    }

}