package com.example.wheretotravel.domain.usecases

import com.example.wheretotravel.domain.models.UserSignIn
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.suspendCancellableCoroutine

class SignInUseCase {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()


    suspend fun signIn(param: UserSignIn): Boolean = suspendCancellableCoroutine { res ->
        mAuth.signInWithEmailAndPassword(
            param.login,
            param.password
        ).addOnCompleteListener{task ->
            res.resume(task.isSuccessful){}
    } }
}