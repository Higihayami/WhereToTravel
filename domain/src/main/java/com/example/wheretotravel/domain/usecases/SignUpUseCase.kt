package com.example.wheretotravel.domain.usecases

import android.util.Log
import com.example.wheretotravel.domain.models.ProfileModel
import com.google.firebase.auth.FirebaseAuth
import com.example.wheretotravel.domain.models.UserSignUp
import com.example.wheretotravel.domain.models.UserWithUID
import com.example.wheretotravel.domain.repository.UserRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.suspendCancellableCoroutine

class SignUpUseCase(private val userRepository: UserRepository) {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var dataBase: DatabaseReference

    suspend fun execute (param: UserSignUp): Boolean {
        userRepository.saveUser(param)
        mAuth = FirebaseAuth.getInstance()
        val result: Boolean = suspendCancellableCoroutine { res ->
            mAuth.createUserWithEmailAndPassword(param.login, param.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userWithUID = UserWithUID(
                            userId = mAuth.currentUser?.uid.toString(),
                            email = param.login,
                            phone = param.phone,
                            password = param.password,
                            firstName = param.name
                        )
                        val user = ProfileModel(
                            email = param.login,
                            phone = param.phone,
                            name = param.name
                        )
                        dataBase = Firebase.database.reference
                        dataBase.child("users").child(mAuth.currentUser?.uid.toString()).child("name").setValue(user.name)
                        dataBase.child("users").child(mAuth.currentUser?.uid.toString()).child("phone").setValue(user.phone)
                        dataBase.child("users").child(mAuth.currentUser?.uid.toString()).child("login").setValue(user.email)
                    }
                    res.resume(task.isSuccessful){}
                }
        }
        return result
    }

    private fun writeNewUser(user: ProfileModel, userId: String) {

    }
}

