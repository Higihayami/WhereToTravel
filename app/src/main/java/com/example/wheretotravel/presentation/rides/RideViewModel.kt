package com.example.wheretotravel.presentation.rides

import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.models.SaveModel
import com.example.wheretotravel.domain.usecases.RidesUseCase

class RideViewModel(
    private val ridesUseCase: RidesUseCase
):ViewModel() {
    fun getTable():List<SaveModel>{
        return ridesUseCase.getModel()
    }
}