package com.example.wheretotravel.di

import android.content.Context
import com.example.wheretotravel.data.repository.RoutesRepositoryImpl
import com.example.wheretotravel.data.storage.RoutesDataBase
import com.example.wheretotravel.data.storage.dao.RoutesDao
import com.example.wheretotravel.domain.repository.RoutesRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideRoutesRepository(dao: RoutesDao): RoutesRepository {
        return RoutesRepositoryImpl(dao)
    }

    @Provides
    fun provideRoutesDb(context: Context): RoutesDao {
        return RoutesDataBase.getInstance(context).getRoutesDao()
    }

}