package com.example.wheretotravel.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.wheretotravel.data.storage.models.Routes

@Dao
interface RoutesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(rotes: Routes)

}