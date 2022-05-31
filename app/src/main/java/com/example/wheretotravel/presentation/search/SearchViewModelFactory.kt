package com.example.wheretotravel.presentation.search

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase

class SearchViewModelFactory(
    val getRoutesTableUseCase: GetRoutesTableUseCase,
    val getRoutesNameUseCase: GetRoutesNameUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchViewModel(getRoutesTableUseCase = getRoutesTableUseCase, getRoutesNameUseCase = getRoutesNameUseCase) as T
    }
}