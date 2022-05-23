package com.example.wheretotravel.domain.functions

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import com.example.wheretotravel.domain.models.UserSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.suspendCancellableCoroutine

class SignIn {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()


    suspend fun execute(param: UserSignIn): Boolean = suspendCancellableCoroutine { res ->
        mAuth.signInWithEmailAndPassword(
            param.login,
            param.password
        ).addOnCompleteListener{task ->
            res.resume(task.isSuccessful){}
    } }
}