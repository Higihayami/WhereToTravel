package com.example.wheretotravel.domain.repository

import RoutesFireBaseModel

interface RoutesRepository {
    fun insert (listRoutes: MutableList<RoutesFireBaseModel?>)
}