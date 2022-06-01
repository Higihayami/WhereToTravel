package com.example.wheretotravel.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.presentation.profile.ProfileViewModel

class ListViewModelFactory(
    val getRoutesNameUseCase: GetRoutesNameUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(getRoutesNameUseCase = getRoutesNameUseCase) as T
    }
}