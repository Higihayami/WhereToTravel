package com.example.wheretotravel.domain.usecases

import com.example.wheretotravel.domain.models.RoutesModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RoutesUseCase {

    private lateinit var dataBase: DatabaseReference

    suspend fun getRoutesId(nameStationArrival : String, nameStationDeparture: String ):RoutesModel{
        dataBase  = Firebase.database.reference
        val numbers = listOf("one", "two", "three", "four")
        val longerThan3 = numbers.filter { it.length > 3 }

        var i: Int = 0
        var arrival_id: Int = 0
        var departure_id: Int = 0
        dataBase.child("routes").get()
        dataBase.child("routes").get()
            .addOnSuccessListener { data ->
                println("Путь: ${data.value}")
            }
            .addOnFailureListener { exception ->
                println("Не удалось получить вокзал из базы")
                exception.printStackTrace()
            }

        val routes = RoutesModel(
            departure_id = departure_id,
            arrival_id = arrival_id
        )
        return routes
    }
}