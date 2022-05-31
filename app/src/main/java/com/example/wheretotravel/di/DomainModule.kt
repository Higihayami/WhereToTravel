package com.example.wheretotravel.di

import com.example.wheretotravel.domain.repository.RoutesRepository
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase
import com.example.wheretotravel.presentation.ROUTES_REPOSITORY
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetRoutesNameUseCase(routesRepository: RoutesRepository):GetRoutesNameUseCase{
        return GetRoutesNameUseCase(routesRepository)
    }

    @Provides
    fun provideGetRoutesTableUseCase(routesRepository: RoutesRepository):GetRoutesTableUseCase{
        return GetRoutesTableUseCase(routesRepository)
    }
}