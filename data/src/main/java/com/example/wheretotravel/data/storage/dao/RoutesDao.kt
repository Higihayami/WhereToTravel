package com.example.wheretotravel.data.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wheretotravel.data.storage.models.Routes
import com.example.wheretotravel.domain.models.RoutesModel

@Dao
interface RoutesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(routes: Routes)

    @Query("SELECT * FROM user_table where arrival_name = :arrival_name and departure_name = :departure_name ")
    suspend fun getId(arrival_name: String, departure_name: String): Routes?

    @Query("SELECT * FROM user_table where arrival_id = :arrival_id and departure_id = :departure_id ")
    fun getName(arrival_id: Int, departure_id: Int): Routes
}