package com.example.wheretotravel.domain.repository

import com.example.wheretotravel.domain.models.SaveNameParam
import com.example.wheretotravel.domain.models.UserName

interface UserRepository {

    fun saveName (saveparam: SaveNameParam): Boolean

    fun getName (): UserName
}