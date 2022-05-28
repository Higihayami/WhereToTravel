package com.example.wheretotravel.presentation.search

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.wheretotravel.data.repository.RoutesRepositoryImpl
import com.example.wheretotravel.data.storage.RoutesDataBase
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase
import com.example.wheretotravel.presentation.ROUTES_REPOSITORY
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Route

class SearchViewModel(application: Application): AndroidViewModel(application) {
    private val context = application
    lateinit var getRoutesTableUseCase: GetRoutesTableUseCase
    lateinit var getRoutesNameUseCase: GetRoutesNameUseCase

    fun getRoutes() {
            val daoRoutes = RoutesDataBase.getInstance(context).getRoutesDao()
            ROUTES_REPOSITORY = RoutesRepositoryImpl(daoRoutes)
            getRoutesTableUseCase = GetRoutesTableUseCase()
            val dispose = getRoutesTableUseCase.getTable(ROUTES_REPOSITORY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.e("aaa", it[0]?.getArrival_Station_Name().toString())
                }
    }
    suspend fun getRoutesName(arrival_name: String , departure_name : String):LiveData<RoutesModel>{
        val daoRoutes = RoutesDataBase.getInstance(context).getRoutesDao()
        ROUTES_REPOSITORY = RoutesRepositoryImpl(daoRoutes)
        getRoutesNameUseCase = GetRoutesNameUseCase()
        val model : LiveData<RoutesModel> = getRoutesNameUseCase.getRoutesName(arrival_name,departure_name, ROUTES_REPOSITORY)
        return model
    }
}