package com.example.wheretotravel.data.storage.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class Routes(
    @PrimaryKey
    val routes_id: String,

    @ColumnInfo
    val arrival_Id: Int,

    @ColumnInfo
    val arrival_name: String,

    @ColumnInfo
    val departure_id: Int,

    @ColumnInfo
    val departure_name: String,
)