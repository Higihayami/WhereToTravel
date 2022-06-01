package com.example.wheretotravel.presentation.list

import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase

class ListViewModel(
    private val  getRoutesNameUseCase: GetRoutesNameUseCase
):ViewModel(
) {
    fun getRoutesId(arrival_id: Int, departure_id: Int): RoutesModel? {
        return getRoutesNameUseCase.getRoutesName(arrival_id, departure_id)
    }
}