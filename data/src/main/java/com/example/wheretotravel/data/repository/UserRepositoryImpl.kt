package com.example.wheretotravel.data.repository

import com.example.wheretotravel.data.storage.models.User
import com.example.wheretotravel.data.storage.UserDataBase
import com.example.wheretotravel.domain.models.UserSignUp
import com.example.wheretotravel.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserDataBase): UserRepository {

    override fun saveUser(saveParam: UserSignUp): Boolean{

        val user = User(login = saveParam.login, phone = saveParam.phone, name = saveParam.name, password = saveParam.password)

        val result = userStorage.save(user)
        return result
    }
}