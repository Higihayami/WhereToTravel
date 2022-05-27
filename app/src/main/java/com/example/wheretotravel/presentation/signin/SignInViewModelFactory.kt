package com.example.wheretotravel.presentation.signin

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase
import com.example.wheretotravel.domain.usecases.SignInUseCase

class SignInViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val signIn by lazy { SignInUseCase() }
    private val getRoutesTable by lazy{ GetRoutesTableUseCase()}

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignInViewModel(signIn = signIn, getRoutesTable = getRoutesTable) as T
    }
}