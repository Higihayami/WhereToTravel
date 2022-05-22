package com.example.wheretotravel.presentation.api


data class Rides(val arrivalTime: String, val departureTime: String, val departureStation: String, val arrivalStation: String, val firm: Boolean, val name: String, val trainNumber: String, val categories: List<String>)
