package com.example.wheretotravel.domain.usecases

import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.repository.RoutesRepository

class GetRoutesNameUseCase(val routesRepository: RoutesRepository) {
    suspend fun getRoutesId(arrival_name: String, departure_name: String): RoutesModel? {
        return routesRepository.getId(arrival_name,departure_name)
    }

    fun getRoutesName(arrival_id: Int, departure_id: Int): RoutesModel{
        return routesRepository.getName(arrival_id, departure_id)
    }
}