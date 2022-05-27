//package com.example.wheretotravel.presentation.signup
//
//import android.content.Context
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.wheretotravel.data.repository.UserRepositoryImpl
//import com.example.wheretotravel.data.storage.room.RoomUserStorage
//import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase
//import com.example.wheretotravel.domain.usecases.SignUpUseCase
//import com.example.wheretotravel.presentation.ROUTES_REPOSITORY
//
//class SignUpViewModelFactory(context: Context): ViewModelProvider.Factory {
//
//    private val userRepository by lazy(LazyThreadSafetyMode.NONE){
//        UserRepositoryImpl(userStorage = RoomUserStorage(context = context))
//    }
//    private val signUp by lazy {SignUpUseCase(userRepository)}
//    //private val getRoutesTable by lazy{ GetRoutesTableUseCase(ROUTES_REPOSITORY) }
//
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return SignUpViewModel(signUp = signUp, getRoutesTable=getRoutesTable) as T
//    }
//}