package com.example.wheretotravel.data.repository

import com.example.wheretotravel.domain.models.SaveNameParam
import com.example.wheretotravel.domain.models.UserName
import com.example.wheretotravel.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository{

    override fun saveName (saveParam: SaveNameParam): Boolean{


        return true
    }

    override fun getName (): UserName{

        return UserName(firstname = "Daniil", lastname = "Fatykov")
    }

}