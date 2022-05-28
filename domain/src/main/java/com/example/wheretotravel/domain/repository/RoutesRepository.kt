package com.example.wheretotravel.domain.repository

import RoutesFireBaseModel

interface RoutesRepository {
    suspend fun insert (listRoutes: MutableList<RoutesFireBaseModel?>)
}