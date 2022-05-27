package com.example.wheretotravel.presentation.signin

import androidx.lifecycle.ViewModel
import com.example.wheretotravel.domain.usecases.SignInUseCase
import com.example.wheretotravel.domain.models.UserSignIn
import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase

class SignInViewModel(
    private val signIn: SignInUseCase,
    private val getRoutesTable: GetRoutesTableUseCase
):ViewModel() {
    suspend fun signIn(param: UserSignIn):Boolean =  signIn.signIn(param)
    fun getRotesTable(){
        getRoutesTable.getTable()
    }
}