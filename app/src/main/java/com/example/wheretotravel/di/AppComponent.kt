package com.example.wheretotravel.di

import com.example.wheretotravel.presentation.search.SearchFragment
import dagger.Component

@Component(modules = [AppModule::class , DataModule::class , DomainModule::class])
interface AppComponent {

    fun inject(searchFragment: SearchFragment)

}