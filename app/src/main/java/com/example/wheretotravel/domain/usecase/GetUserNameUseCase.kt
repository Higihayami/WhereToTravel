package com.example.wheretotravel.domain.usecase

import com.example.wheretotravel.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName{
        return UserName(firstname = "Daniil", lastname = "Fatykov")
    }
}