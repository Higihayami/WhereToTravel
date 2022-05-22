package com.example.wheretotravel.presentation.main.fragment.search

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wheretotravel.presentation.signin.SignInViewModel

class SearchViewModelFactory(context: SearchFragment): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchViewModel() as T
    }
}