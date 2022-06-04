package com.example.wheretotravel.presentation.signup

import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.usecases.SignUpUseCase
import com.example.wheretotravel.domain.models.UserSignUp
import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val signUp: SignUpUseCase,
) : ViewModel() {

    suspend fun login(param: UserSignUp) : Boolean = signUp.execute(param)
}