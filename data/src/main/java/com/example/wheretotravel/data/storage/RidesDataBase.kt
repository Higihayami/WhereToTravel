package com.example.wheretotravel.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wheretotravel.data.storage.dao.RidesDao
import com.example.wheretotravel.data.storage.dao.RoutesDao
import com.example.wheretotravel.data.storage.models.Rides
import com.example.wheretotravel.data.storage.models.Routes

@Database(entities = [Rides::class, Routes::class], version = 2)
abstract class RidesDataBase:RoomDatabase() {
    abstract fun getRidesDao(): RidesDao

    companion object {
        private var database: RidesDataBase? = null

        @Synchronized
        fun getInstance(context: Context): RidesDataBase {
            return if (database == null) {
                database = Room.databaseBuilder(context, RidesDataBase::class.java, "rides_table")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build()
                database as RidesDataBase
            } else {
                database as RidesDataBase
            }
        }
    }
}