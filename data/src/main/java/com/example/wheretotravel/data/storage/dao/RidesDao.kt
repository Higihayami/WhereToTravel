package com.example.wheretotravel.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wheretotravel.data.storage.models.Rides
import com.example.wheretotravel.data.storage.models.Routes

@Dao
interface RidesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(rides: Rides)

    @Query("SELECT * FROM rides_table")
    fun getTable():List<Rides>
}