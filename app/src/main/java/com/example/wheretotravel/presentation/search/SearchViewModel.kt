package com.example.wheretotravel.presentation.search

import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel(
    private val getRoutesTableUseCase: GetRoutesTableUseCase,
    private val getRoutesNameUseCase: GetRoutesNameUseCase
) : ViewModel() {

    fun getRoutes() {
        getRoutesTableUseCase.getTable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    suspend fun getRoutesName(arrival_name: String, departure_name: String): RoutesModel? {
        return getRoutesNameUseCase.getRoutesId(arrival_name, departure_name)
    }
}