package com.example.bolt.repositories


import android.util.Log
import com.example.bolt.BaseApplication
import javax.inject.Inject
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.first

class DataStoreRepository @Inject constructor(
    private var app: BaseApplication
) {

    companion object{
        const val PREFRENCE_NAME = "custom_preference"
    }

    private object PreferncesKey{
        val isLogin = preferencesKey<Boolean>("isLogin")
    }

    private val dataStore: DataStore<Preferences> = app.createDataStore(
            name = PREFRENCE_NAME,
    )

    //login edit function
    suspend fun saveLoginValue(islogin: Boolean){
        Log.d("login",islogin.toString())
        dataStore.edit{ preferences ->
        preferences[PreferncesKey.isLogin]  = islogin
        }
    }
    //login read function
    suspend fun readLoginValue() : Boolean {
        val dataStoreKey = preferencesKey<Boolean>("isLogin")
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey] ?: false
    }
}