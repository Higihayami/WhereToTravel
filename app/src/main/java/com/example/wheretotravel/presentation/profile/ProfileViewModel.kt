package com.example.wheretotravel.presentation.profile

import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.usecases.ProfileUseCase

class ProfileViewModel(
    private val profile:ProfileUseCase
):ViewModel() {

    suspend fun getName(userId: String):String = profile.getName(userId)

    suspend fun getPhone(userId: String):String = profile.getPhone(userId)
}