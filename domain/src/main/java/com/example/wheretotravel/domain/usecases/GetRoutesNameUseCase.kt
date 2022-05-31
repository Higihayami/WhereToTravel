package com.example.wheretotravel.domain.usecases

import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.repository.RoutesRepository

class GetRoutesNameUseCase(val routesRepository: RoutesRepository) {
    suspend fun getRoutesName(arrival_name: String, departure_name: String): RoutesModel {
        return routesRepository.getName(arrival_name,departure_name)
    }
}