//package com.example.wheretotravel.presentation.search
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//
//class SearchViewModelFactory(val context: SearchFragment): ViewModelProvider.Factory {
//    val application: SearchFragment = context
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return SearchViewModel(application = application.context) as T
//    }
//}