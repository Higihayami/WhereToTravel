package com.example.wheretotravel.presentation.help

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.presentation.profile.ProfileViewModel

class HelpViewModelFactory(context: HelpFragment):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HelpViewModel() as T
    }
}