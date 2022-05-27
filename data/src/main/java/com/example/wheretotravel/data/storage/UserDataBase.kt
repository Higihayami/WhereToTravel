package com.example.wheretotravel.data.storage

import com.example.wheretotravel.data.storage.models.User

interface UserDataBase {
    fun save(user: User): Boolean
}