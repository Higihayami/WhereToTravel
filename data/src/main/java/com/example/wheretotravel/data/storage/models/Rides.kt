package com.example.wheretotravel.data.storage.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "rides_table")
class Rides(

    @PrimaryKey
    val rides_id: UUID,

    @ColumnInfo
    val arrival_name: String,

    @ColumnInfo
    val departure_name: String,

    @ColumnInfo
    val date: String,

    @ColumnInfo
    val travel_time: String,

    @ColumnInfo
    val number_train: String,

    @ColumnInfo
    val firm: String?,

    @ColumnInfo
    val firm_bool: Boolean,

    @ColumnInfo
    val arrival_time: String,

    @ColumnInfo
    val departure_time: String
)