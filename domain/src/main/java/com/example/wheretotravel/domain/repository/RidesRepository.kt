package com.example.wheretotravel.domain.repository

import com.example.wheretotravel.domain.models.SaveModel

interface RidesRepository {
    fun setModel (saveModel: SaveModel)
    fun getModel (): List<SaveModel>
}