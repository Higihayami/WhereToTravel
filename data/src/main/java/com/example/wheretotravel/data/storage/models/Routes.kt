package com.example.wheretotravel.data.storage.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table", primaryKeys = ["arrival_Id", "departure_id"])
class Routes(

    val arrival_Id: Int,

    @ColumnInfo
    val arrival_name: String,

    val departure_id: Int,

    @ColumnInfo
    val departure_name: String,
)