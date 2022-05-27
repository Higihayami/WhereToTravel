package com.example.wheretotravel.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wheretotravel.data.storage.dao.RoutesDao
import com.example.wheretotravel.data.storage.models.Routes

@Database(entities = [Routes::class], version = 1)
abstract class RoutesDataBase: RoomDatabase() {
        abstract fun getRoutesDao(): RoutesDao

        companion object {
            private var database: RoutesDataBase? = null

            @Synchronized
            fun getInstance(context: Context): RoutesDataBase {
                return if (database == null) {
                    database = Room.databaseBuilder(context, RoutesDataBase::class.java, "dbOrd").allowMainThreadQueries().fallbackToDestructiveMigration().build()
                    database as RoutesDataBase
                } else {
                    database as RoutesDataBase
                }
            }
        }
    }