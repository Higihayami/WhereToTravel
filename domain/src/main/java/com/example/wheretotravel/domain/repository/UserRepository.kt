package com.example.wheretotravel.domain.repository

import com.example.wheretotravel.domain.models.UserSignUp

interface UserRepository {
    fun saveUser(saveParam: UserSignUp):Boolean
}