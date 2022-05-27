package com.example.wheretotravel.domain.usecases

import RoutesFireBaseModel
import android.util.Log
import com.example.wheretotravel.domain.models.RoutesModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GetRoutesTableUseCase {

    fun getTable(){
        GlobalScope.launch(Dispatchers.IO){
            val rootRef = FirebaseDatabase.getInstance().reference
            val messageRef =
                rootRef.child("Routes")
            val valueEventListener: ValueEventListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val productsList: MutableList<RoutesFireBaseModel?> = ArrayList<RoutesFireBaseModel?>()
                    for (ds in dataSnapshot.children) {
                        val messages: RoutesFireBaseModel? = ds.getValue(RoutesFireBaseModel::class.java)
                        productsList.add(messages)
                    }
                    mapProduct(productsList)
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
            messageRef.addListenerForSingleValueEvent(valueEventListener)
        }
    }

    fun mapProduct(listCloud: MutableList<RoutesFireBaseModel?>){
        var listRoom: List<RoutesModel> = mutableListOf()
        listCloud.forEach { cloud ->
            val productData = RoutesModel(
                arrival_id = cloud?.getArrival_Station_Id().toString().toInt(),
                arrival_name = cloud?.getArrival_Station_Name(),
                departure_id = cloud?.getdeparture_station_id().toString().toInt(),
                departure_name = cloud?.getDeparture_station_name(),
            )
            listRoom = listRoom + productData
        }
        Log.e("firebase",listRoom[0].arrival_name.toString())
        //val productInsetRoom = ProductInsetRoom()
        //productInsetRoom.insert(listRoom)
    }
}