package com.example.wheretotravel.domain.functions

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.TextUtils
import android.widget.Toast
import com.example.wheretotravel.domain.models.UserSignUp
import com.example.wheretotravel.domain.repository.UserRepository

class SignUp(private val userRepository: UserRepository) {

    private lateinit var mAuth: FirebaseAuth

    fun execute (param: UserSignUp, context: Context){
        userRepository.saveUser(param)
        mAuth = FirebaseAuth.getInstance()
        if(param.password == param.repeatPassword) {
            if (!TextUtils.isEmpty(param.login) && !TextUtils.isEmpty(param.password)) {
                mAuth.createUserWithEmailAndPassword(param.login, param.password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful)
                            Toast.makeText(context, "succes", Toast.LENGTH_SHORT).show()
                        else
                            Toast.makeText(context, "not", Toast.LENGTH_SHORT).show()
                    }
            }
            else
                Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(context, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
    }
}

