package com.example.wheretotravel.data.repository

import android.content.Context
import com.example.wheretotravel.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstname"
private const val KEY_LAST_NAME = "lastname"
private const val DEFAULT_NAME = "Default last namr"

class UserRepositoryImpl(context: Context) : UserRepository{

    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    //override fun saveName (saveParam: SaveNameParam): Boolean{

       // sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name)

        //return true
    //}

    //override fun getName (): UserName{

       //val firstName = sharedPreferences.getString(KEY_FIRST_NAME,"") ?:""
       // val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME)?: DEFAULT_NAME

        //return UserName(firstname = firstName, lastname = lastName)
    //}

}