package com.example.wheretotravel.di

import android.content.Context
import com.example.wheretotravel.domain.usecases.GetRoutesNameUseCase
import com.example.wheretotravel.domain.usecases.GetRoutesTableUseCase
import com.example.wheretotravel.domain.usecases.RidesUseCase
import com.example.wheretotravel.presentation.list.ListViewModelFactory
import com.example.wheretotravel.presentation.rides.RideViewModelFactory
import com.example.wheretotravel.presentation.search.SearchViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext():Context{
        return context
    }

    @Provides
    fun provideSearchViewModelFactory(
        getRoutesTableUseCase: GetRoutesTableUseCase,
        getRoutesNameUseCase: GetRoutesNameUseCase
    ): SearchViewModelFactory {
        return SearchViewModelFactory(
            getRoutesTableUseCase = getRoutesTableUseCase,
            getRoutesNameUseCase = getRoutesNameUseCase
        )
    }

    @Provides
    fun provideListViewModelFactory(
        getRoutesNameUseCase: GetRoutesNameUseCase,
        ridesUseCase: RidesUseCase
    ): ListViewModelFactory {
        return ListViewModelFactory(
            getRoutesNameUseCase = getRoutesNameUseCase,
            ridesUseCase = ridesUseCase
        )
    }

    @Provides
    fun provideRideViewModelFactory(
        ridesUseCase: RidesUseCase
    ): RideViewModelFactory {
        return RideViewModelFactory(
            ridesUseCase = ridesUseCase
        )
    }
}