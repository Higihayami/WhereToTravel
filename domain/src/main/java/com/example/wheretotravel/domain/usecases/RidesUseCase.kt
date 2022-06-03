package com.example.wheretotravel.domain.usecases

import com.example.wheretotravel.domain.models.SaveModel
import com.example.wheretotravel.domain.repository.RidesRepository

class RidesUseCase(val ridesRepository: RidesRepository) {
    fun setModel(saveModel: SaveModel){
        ridesRepository.setModel(saveModel)
    }
    fun getModel(): List<SaveModel> {
        return ridesRepository.getModel()
    }
}