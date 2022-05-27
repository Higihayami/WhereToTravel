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
                println("Пользователь: ${data.value}")
            }
            .addOnFailureListener { exception ->
                println("Не удалось получить пользователя из базы")
                exception.printStackTrace()
            }
       // while ( i <= 50705){
//
       //     val departure_name: String = suspendCancellableCoroutine { res ->
       //         dataBase.child("routes").child(i.toString()).child("departure_station_name").get().addOnSuccessListener {
       //             res.resume(it.value.toString()) {}
       //         }
       //     }
       //     Log.e("aye", departure_name)
       //     if(nameStationDeparture == departure_name ){
       //         val arrival:String = suspendCancellableCoroutine { res ->
       //             dataBase.child("routes").child(i.toString()).child("arrival_station_name").get().addOnSuccessListener {
       //                 res.resume(it.value.toString()) {}
       //             }
       //         }
       //         if(nameStationArrival == arrival){
       //             arrival_id =  suspendCancellableCoroutine { res ->
       //                 dataBase.child("routes").child(i.toString()).child("arrival_station_id").get().addOnSuccessListener {
       //                     res.resume(it.value.toString().toInt()) {}
       //                 }
       //             }
       //             departure_id = suspendCancellableCoroutine { res ->
       //                 dataBase.child("routes").child(i.toString()).child("departure_station_id").get().addOnSuccessListener {
       //                     res.resume(it.value.toString().toInt()) {}
       //                 }
//
       //             }
       //             break
       //         }
       //     }
       //     i++
       // }

        val routes = RoutesModel(
            departure_id = departure_id,
            arrival_id = arrival_id
        )
        return routes
    }
}