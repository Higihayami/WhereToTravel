package com.example.wheretotravel.di

import android.content.Context
import com.example.wheretotravel.data.repository.RidesRepositoryImpl
import com.example.wheretotravel.data.repository.RoutesRepositoryImpl
import com.example.wheretotravel.data.repository.UserRepositoryImpl
import com.example.wheretotravel.data.storage.RidesDataBase
import com.example.wheretotravel.data.storage.RoutesDataBase
import com.example.wheretotravel.data.storage.UserDataBase
import com.example.wheretotravel.data.storage.dao.RidesDao
import com.example.wheretotravel.data.storage.dao.RoutesDao
import com.example.wheretotravel.domain.repository.RidesRepository
import com.example.wheretotravel.domain.repository.RoutesRepository
import com.example.wheretotravel.domain.repository.UserRepository
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

    @Provides
    fun provideRidesRepository(dao: RidesDao): RidesRepository {
        return RidesRepositoryImpl(dao)
    }
    @Provides
    fun provideRidesDb(context: Context): RidesDao {
        return RidesDataBase.getInstance(context).getRidesDao()
    }
}