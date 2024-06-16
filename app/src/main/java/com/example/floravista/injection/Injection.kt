package com.example.floravista.injection

import android.content.Context
import com.example.floravista.UserRepository
import com.example.floravista.data.pref.UserPreferences
import com.example.floravista.data.pref.dataStore
import com.example.floravista.data.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreferences.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(pref, apiService)
    }
}