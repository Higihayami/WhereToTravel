package com.example.wheretotravel.data.storage

import com.example.wheretotravel.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
}