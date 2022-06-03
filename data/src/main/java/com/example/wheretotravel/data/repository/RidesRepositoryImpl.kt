package com.example.wheretotravel.data.repository

import android.util.Log
import com.example.wheretotravel.data.storage.dao.RidesDao
import com.example.wheretotravel.data.storage.models.Rides
import com.example.wheretotravel.domain.models.SaveModel
import com.example.wheretotravel.domain.repository.RidesRepository
import java.util.*

class RidesRepositoryImpl(private val dao: RidesDao): RidesRepository {

    override fun setModel(saveModel: SaveModel) {
        val rides = Rides(
            arrival_time = saveModel.arrival_time,
            departure_time = saveModel.departure_time,
            arrival_name = saveModel.arrival_name,
            departure_name = saveModel.departure_name,
            date = saveModel.date,
            travel_time = saveModel.travel_time,
            firm = saveModel.firm,
            firm_bool = saveModel.firm_bool,
            number_train = saveModel.number_train,
            rides_id = UUID.randomUUID()
        )
        Log.e("OTEM", rides.arrival_name)
        dao.insert(rides)
    }

    override fun getModel(): List<SaveModel> {
        val ride = dao.getTable()
        var listRides :List<SaveModel> = mutableListOf()
        ride.forEach {  cloud ->
            val rideDomain = SaveModel(
                arrival_name = cloud.arrival_name,
                departure_name = cloud.departure_name,
                arrival_time = cloud.arrival_time,
                departure_time = cloud.departure_time,
                travel_time = cloud.travel_time,
                number_train = cloud.number_train,
                date = cloud.date,
                firm = cloud.firm,
                firm_bool = cloud.firm_bool
            )
            listRides = listRides + rideDomain
        }
        return  listRides
    }
}