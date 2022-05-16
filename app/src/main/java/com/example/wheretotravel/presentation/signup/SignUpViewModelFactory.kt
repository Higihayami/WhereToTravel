package com.example.wheretotravel.presentation.signup

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.data.repository.UserRepositoryImpl
import com.example.wheretotravel.data.storage.room.RoomUserStorage
import com.example.wheretotravel.domain.functions.SignUp

class SignUpViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE){
        UserRepositoryImpl(userStorage = RoomUserStorage(context = context))
    }
    private val signUp by lazy {SignUp(userRepository)}


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(signUp = signUp) as T
    }
}