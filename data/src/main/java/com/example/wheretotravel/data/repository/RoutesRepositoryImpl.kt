package com.example.wheretotravel.data.repository

import RoutesFireBaseModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.wheretotravel.data.storage.dao.RoutesDao
import com.example.wheretotravel.data.storage.models.Routes
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.repository.RoutesRepository
import java.util.*

class RoutesRepositoryImpl(private val dao: RoutesDao): RoutesRepository {
        override suspend fun insert(listRoutes: MutableList<RoutesFireBaseModel?>) {
        var listRoom: List<Routes> = mutableListOf()
        val routesId = UUID.randomUUID().toString()
        listRoutes.forEach { cloud ->
            val productData = Routes(
                arrival_Id = cloud?.getArrival_Station_Id().toString().toInt(),
                arrival_name = cloud?.getArrival_Station_Name().toString(),
                departure_id = cloud?.getdeparture_station_id().toString().toInt(),
                departure_name = cloud?.getDeparture_station_name().toString(),
                routes_id = routesId
            )
            listRoom = listRoom + productData
        }
        Log.e("FFF", listRoom[0].arrival_name)
        listRoom.forEach{
            dao.insert(it)
        }
    }

    override suspend fun getName(arrival_name: String, departure_name: String): LiveData<RoutesModel> {
        return dao.getName(arrival_name =arrival_name ,departure_name =departure_name).map { routesModel ->
            RoutesModel(
                arrival_name = routesModel.arrival_name,
                departure_name = routesModel.departure_name,
                arrival_id = routesModel.arrival_Id,
                departure_id = routesModel.departure_id,
            )
        }
    }
}