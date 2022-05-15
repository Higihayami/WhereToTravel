package com.example.wheretotravel.domain.functions

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import com.example.wheretotravel.domain.models.UserSignIn
import com.google.firebase.auth.FirebaseAuth

class SignIn {

    private lateinit var mAuth: FirebaseAuth


    fun execute(param: UserSignIn, context: Context){

        mAuth = FirebaseAuth.getInstance()
        if(!TextUtils.isEmpty(param.login) && !TextUtils.isEmpty(param.password)) {
            mAuth.signInWithEmailAndPassword(
                param.login,
                param.password
            ).addOnCompleteListener{task ->
                if (task.isSuccessful)
                    Toast.makeText(context, "succes", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(context, "not", Toast.LENGTH_SHORT).show()
            }
        }
    }
}