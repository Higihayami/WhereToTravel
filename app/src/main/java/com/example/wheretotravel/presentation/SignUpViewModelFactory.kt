package com.example.wheretotravel.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.domain.functions.SignUp

class SignUpViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val signUp by lazy {SignUp()}


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(signUp = signUp) as T
    }
}