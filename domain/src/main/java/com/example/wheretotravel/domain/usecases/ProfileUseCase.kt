package com.example.wheretotravel.domain.usecases

import android.content.ContentValues.TAG
import android.util.Log
import com.example.wheretotravel.domain.models.ProfileModel
import com.example.wheretotravel.domain.models.UserSignUp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.suspendCancellableCoroutine

class ProfileUseCase {
    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var dataBase: DatabaseReference


    suspend fun getName(userId: String):String = suspendCancellableCoroutine { res ->
        val dataBase  = Firebase.database.reference
        dataBase.child("users").child(userId).child("name").get().addOnSuccessListener{
            res.resume(it.value.toString()) {}
        }
    }

    suspend fun getPhone(userId: String):String = suspendCancellableCoroutine { res ->
        val dataBase  = Firebase.database.reference
        dataBase.child("users").child(userId).child("phone").get().addOnSuccessListener{
            res.resume(it.value.toString()) {}
        }
    }

    suspend fun getEmail(userId: String):String = suspendCancellableCoroutine { res ->
        val dataBase  = Firebase.database.reference
        dataBase.child("users").child(userId).child("login").get().addOnSuccessListener{
            res.resume(it.value.toString()) {}
        }
    }

    suspend fun signOut(){
        FirebaseAuth.getInstance().signOut()
    }


}