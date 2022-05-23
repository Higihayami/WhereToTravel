package com.example.wheretotravel.presentation.signin

import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.functions.SignIn
import com.example.wheretotravel.domain.models.UserSignIn

class SignInViewModel(
    private val signIn: SignIn
):ViewModel() {
    suspend fun signIn(param: UserSignIn):Boolean =  signIn.execute(param)
}