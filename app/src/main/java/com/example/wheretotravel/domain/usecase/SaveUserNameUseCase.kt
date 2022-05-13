package com.example.wheretotravel.domain.usecase
import com.example.wheretotravel.data.repository.UserRepositoryImpl
import com.example.wheretotravel.domain.models.SaveNameParam

class SaveUserNameUseCase(private val userRepository: UserRepositoryImpl) {

    fun execute(param: SaveNameParam): Boolean {
        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}