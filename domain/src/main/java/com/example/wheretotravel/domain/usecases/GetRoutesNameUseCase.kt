package com.example.wheretotravel.domain.usecases

import androidx.lifecycle.LiveData
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.repository.RoutesRepository

class GetRoutesNameUseCase {
    suspend fun getRoutesName(arrival_name:String , departure_name:String,routesRepository : RoutesRepository):LiveData<RoutesModel>{
        val routesModel : LiveData<RoutesModel> = routesRepository.getName(arrival_name , departure_name)
        return routesModel
    }
}