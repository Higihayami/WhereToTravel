package com.example.wheretotravel.data.repository

import RoutesFireBaseModel
import android.util.Log
import com.example.wheretotravel.data.storage.dao.RoutesDao
import com.example.wheretotravel.data.storage.models.Routes
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.repository.RoutesRepository
import java.util.*

class RoutesRepositoryImpl(private val dao: RoutesDao) : RoutesRepository {

    override suspend fun insert(listRoutes: MutableList<RoutesFireBaseModel?>) {
        var listRoom: List<Routes> = mutableListOf()
        listRoutes.forEach { cloud ->
            val productData = Routes(
                arrival_Id = cloud?.getArrival_Station_Id().toString().toInt(),
                arrival_name = cloud?.getArrival_Station_Name().toString(),
                departure_id = cloud?.getdeparture_station_id().toString().toInt(),
                departure_name = cloud?.getDeparture_station_name().toString(),
            )
            listRoom = listRoom + productData

            Log.e("FFF", productData.arrival_name)

        }
        listRoom.forEach {
            dao.insert(it)
        }
    }

    override suspend fun getId(departure_name:String, arrival_name: String ): RoutesModel? {
        val rout = dao.getId(arrival_name =arrival_name ,departure_name =departure_name)
        val routes: RoutesModel? = rout?.let {
            RoutesModel(
                arrival_name = rout?.arrival_name,
                arrival_id = it.arrival_Id,
                departure_name = rout.departure_name,
                departure_id = rout.departure_id
            )
        }
        return routes
    }

    override fun getName(arrival_id: Int, departure_id: Int): RoutesModel {
        val rout = dao.getName(arrival_id = arrival_id ,departure_id = departure_id)
        val routes = RoutesModel(
                arrival_name = rout.arrival_name,
                arrival_id = rout.arrival_Id,
                departure_name = rout.departure_name,
                departure_id = rout.departure_id
            )

        return routes
    }
}
