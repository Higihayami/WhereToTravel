package com.example.wheretotravel.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.domain.usecases.RidesUseCase

class ListViewModelFactory(
    val getRoutesNameUseCase: GetRoutesNameUseCase,
    val ridesUseCase: RidesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(getRoutesNameUseCase = getRoutesNameUseCase, ridesUseCase = ridesUseCase) as T
    }
}