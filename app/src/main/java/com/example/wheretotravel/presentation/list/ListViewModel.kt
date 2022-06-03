package com.example.wheretotravel.presentation.list

import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.models.SaveModel
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.domain.usecases.RidesUseCase

class ListViewModel(
    private val  getRoutesNameUseCase: GetRoutesNameUseCase,
    private val ridesUseCase: RidesUseCase
):ViewModel(
) {
    fun getRoutesId(arrival_id: Int, departure_id: Int): RoutesModel? {
        return getRoutesNameUseCase.getRoutesName(arrival_id, departure_id)
    }
    fun setRides(saveModel: SaveModel){
        ridesUseCase.setModel(saveModel)
    }
}