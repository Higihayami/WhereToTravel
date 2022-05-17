package com.example.wheretotravel.presentation.signin

import android.content.Context
import android.widget.EditText
import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.functions.SignIn
import com.example.wheretotravel.domain.models.UserSignIn
import com.example.wheretotravel.domain.models.UserSignUp

class SignInViewModel(
    private val signIn: SignIn
):ViewModel() {

    fun signIn(edLogin:EditText , edPassword: EditText, context: Context): Boolean{
        if(!(edLogin.text.toString().isEmpty() && edPassword.text.toString().isEmpty())){
            val param = UserSignIn(
                login = edLogin.text.toString(),
                password = edPassword.text.toString())
            return (signIn.execute(param, context))
        }
        else
            return false
    }
}