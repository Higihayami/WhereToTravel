package com.example.wheretotravel.data.storage.room

import android.content.Context
import com.example.wheretotravel.data.storage.UserDataBase
import com.example.wheretotravel.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME = "name"
private const val KEY_LOGIN = "login"
private const val KEY_PHONE = "phone"

class RoomUserStorage(context: Context): UserDataBase {

    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User):Boolean{
        sharedPreferences.edit().putString(KEY_NAME, user.name).apply()
        sharedPreferences.edit().putString(KEY_LOGIN, user.login).apply()
        sharedPreferences.edit().putString(KEY_PHONE, user.phone).apply()

        return true
    }
}