package com.example.wheretotravel.presentation.signup

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.data.repository.UserRepositoryImpl
import com.example.wheretotravel.domain.functions.SignUp
import com.example.wheretotravel.domain.repository.UserRepository

class SignUpViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository by lazy{
    }
    private val signUp by lazy {SignUp(userRepository = )}


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(signUp = signUp) as T
    }
}