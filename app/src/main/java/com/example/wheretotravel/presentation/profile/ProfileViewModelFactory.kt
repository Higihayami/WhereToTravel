package com.example.wheretotravel.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.domain.usecases.ProfileUseCase

class ProfileViewModelFactory(context: ProfileFragment):ViewModelProvider.Factory {

        private val profile by lazy {
            ProfileUseCase()
        }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(profile = profile) as T
    }
}