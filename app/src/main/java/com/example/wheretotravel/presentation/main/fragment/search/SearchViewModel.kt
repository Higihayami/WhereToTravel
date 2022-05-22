package com.example.wheretotravel.presentation.main.fragment.search

import android.util.Log
import androidx.lifecycle.ViewModel

class SearchViewModel():ViewModel() {
    init{
        Log.e("AAA","vm created")
    }

    override fun onCleared() {
        Log.e("AAA","vm cleared")
        super.onCleared()
    }
}