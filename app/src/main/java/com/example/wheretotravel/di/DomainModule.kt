package com.example.wheretotravel.di

import com.example.wheretotravel.domain.repository.RidesRepository
import com.example.wheretotravel.domain.repository.RoutesRepository
import com.example.wheretotravel.domain.repository.UserRepository
import com.example.wheretotravel.domain.usecases.*
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

    @Provides
    fun provideSetRidesUseCase(ridesRepository: RidesRepository): RidesUseCase{
        return RidesUseCase(ridesRepository)
    }

    @Provides
    fun provideProfileUseCase(): ProfileUseCase{
        return  ProfileUseCase()
    }

    @Provides
    fun provideSignInUseCase(): SignInUseCase{
        return SignInUseCase()
    }

    @Provides
    fun provideSignUpUseCase(): SignUpUseCase{
        return  SignUpUseCase()
    }
}