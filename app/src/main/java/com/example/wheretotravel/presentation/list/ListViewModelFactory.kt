package com.example.wheretotravel.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.presentation.profile.ProfileViewModel

class ListViewModelFactory(context: ListFragment): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel() as T
    }
}