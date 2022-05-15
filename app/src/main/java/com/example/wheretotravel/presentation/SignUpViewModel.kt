package com.example.wheretotravel.presentation

import android.content.Context
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.functions.SignUp
import com.example.wheretotravel.domain.models.UserSignUp
import com.google.firebase.auth.FirebaseAuth

class SignUpViewModel(
    private val signUp: SignUp
): ViewModel() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var vm: SignUpViewModel

    init {
        Log.e("AAA","VM created")
    }

    override fun onCleared() {
        Log.e("AAA","VM cleared")
        super.onCleared()
    }

    fun login(edLogin: EditText ,edPhone: EditText, edName: EditText, edPassword:EditText, edRepeatPassword: EditText, context: Context){
        if(!(edLogin.text.toString().isEmpty() && edPhone.text.toString().isEmpty() && edName.text.toString().isEmpty() && edPassword.text.toString().isEmpty() && edRepeatPassword.text.toString().isEmpty())) {
            val param = UserSignUp(
                login = edLogin.text.toString(),
                phone = edPhone.text.toString(),
                name = edName.text.toString(),
                password = edPassword.text.toString(),
                repeatPassword = edRepeatPassword.text.toString())
            signUp.execute(param, context)
        }
        else
            Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
    }
}