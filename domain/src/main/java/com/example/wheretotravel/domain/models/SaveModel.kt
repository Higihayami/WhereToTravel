package com.example.wheretotravel.domain.models

class SaveModel(
    val arrival_name: String,
    val departure_name: String,
    val date: String,
    val travel_time: String,
    val number_train: String,
    val firm: String?,
    val firm_bool: Boolean,
    val arrival_time: String,
    val departure_time: String
)