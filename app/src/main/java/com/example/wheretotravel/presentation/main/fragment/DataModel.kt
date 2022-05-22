package com.example.wheretotravel.presentation.main.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wheretotravel.presentation.api.response.Trip

open class DataModel: ViewModel() {
    val message: MutableLiveData<List<Trip>> by lazy {
        MutableLiveData<List<Trip>>()
    }
}