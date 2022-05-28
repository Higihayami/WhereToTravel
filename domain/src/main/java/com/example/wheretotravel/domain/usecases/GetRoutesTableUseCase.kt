package com.example.wheretotravel.domain.usecases

import RoutesFireBaseModel
import android.util.Log
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.repository.RoutesRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GetRoutesTableUseCase() {

    fun getTable(routesRepository: RoutesRepository):Flowable<MutableList<RoutesFireBaseModel?>>{
        return Flowable.create({ subscribe ->
            val rootRef = FirebaseDatabase.getInstance().reference
            val messageRef =
                rootRef.child("Routes")
            val valueEventListener: ValueEventListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val routesList: MutableList<RoutesFireBaseModel?> =
                        ArrayList<RoutesFireBaseModel?>()
                    for (ds in dataSnapshot.children) {
                        val messages: RoutesFireBaseModel? =
                            ds.getValue(RoutesFireBaseModel::class.java)
                        routesList.add(messages)
                    }
                    GlobalScope.launch (Dispatchers.IO){
                        routesRepository.insert(listRoutes = routesList)
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
            messageRef.addListenerForSingleValueEvent(valueEventListener)
        },BackpressureStrategy.BUFFER)
    }


}