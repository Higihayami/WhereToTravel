package com.example.wheretotravel.presentation.rides

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.presentation.profile.ProfileViewModel

class RideViewModelFactory(context: RideFragment):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RideViewModel() as T
    }
}