package com.example.wheretotravel.domain.repository

import RoutesFireBaseModel
import androidx.lifecycle.LiveData
import com.example.wheretotravel.domain.models.RoutesModel
import com.example.wheretotravel.domain.models.SaveModel

interface RoutesRepository {
    suspend fun insert (listRoutes: MutableList<RoutesFireBaseModel?>)
    suspend fun getId (arrival_name: String, departure_name: String) :RoutesModel?
    fun getName (arrival_id: Int, departure_id: Int) :RoutesModel?

}