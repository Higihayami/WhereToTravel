package com.example.wheretotravel.presentation.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.wheretotravel.data.repository.RoutesRepositoryImpl
import com.example.wheretotravel.data.storage.RoutesDataBase
import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase
import com.example.wheretotravel.presentation.ROUTES_REPOSITORY
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel(application: Application): AndroidViewModel(application) {
    private val context = application
    lateinit var getRoutesTableUseCase: GetRoutesTableUseCase

    fun getRoutes(){
        val daoRoutes = RoutesDataBase.getInstance(context).getRoutesDao()
        ROUTES_REPOSITORY = RoutesRepositoryImpl(daoRoutes)
        getRoutesTableUseCase = GetRoutesTableUseCase()
        getRoutesTableUseCase.getTable(ROUTES_REPOSITORY)
        val dispose = getRoutesTableUseCase.getTable(ROUTES_REPOSITORY)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }
}