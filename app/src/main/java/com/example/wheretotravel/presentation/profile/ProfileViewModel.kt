package com.example.wheretotravel.presentation.profile

import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.usecases.ProfileUseCase
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val profile:ProfileUseCase
):ViewModel() {

    suspend fun getName(userId: String):String = profile.getName(userId)

    suspend fun getPhone(userId: String):String = profile.getPhone(userId)

    suspend fun getEmail(userId: String):String = profile.getEmail(userId)

    suspend fun signOut() = profile.signOut()
}