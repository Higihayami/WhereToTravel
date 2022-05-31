package com.example.wheretotravel.domain.repository

import RoutesFireBaseModel
import androidx.lifecycle.LiveData
import com.example.wheretotravel.domain.models.RoutesModel

interface RoutesRepository {
    suspend fun insert (listRoutes: MutableList<RoutesFireBaseModel?>)
    suspend fun getName (arrival_name: String, departure_name: String) :RoutesModel
}