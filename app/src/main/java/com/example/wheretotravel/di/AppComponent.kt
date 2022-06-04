package com.example.wheretotravel.di

import com.example.wheretotravel.presentation.MainActivity
import com.example.wheretotravel.presentation.list.ListFragment
import com.example.wheretotravel.presentation.profile.ProfileFragment
import com.example.wheretotravel.presentation.rides.RideFragment
import com.example.wheretotravel.presentation.search.SearchFragment
import com.example.wheretotravel.presentation.signin.SignInActivity
import com.example.wheretotravel.presentation.signup.SignUpActivity
import dagger.Component

@Component(modules = [AppModule::class , DataModule::class , DomainModule::class, ViewModelModule:: class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(signInActivity: SignInActivity)

    fun inject(signUpActivity: SignUpActivity)
}