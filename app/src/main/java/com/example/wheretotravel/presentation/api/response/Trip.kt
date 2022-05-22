package com.example.wheretotravel.presentation.api.response


import com.google.gson.annotations.SerializedName

data class Trip(
    @SerializedName("arrivalStation")
    var arrivalStation: String,
    @SerializedName("arrivalTime")
    var arrivalTime: String,
    @SerializedName("categories")
    var categories: List<Category>,
    @SerializedName("departureStation")
    var departureStation: String,
    @SerializedName("departureTime")
    var departureTime: String,
    @SerializedName("firm")
    var firm: Boolean,
    @SerializedName("name")
    var name: String,
    @SerializedName("numberForUrl")
    var numberForUrl: String,
    @SerializedName("runArrivalStation")
    var runArrivalStation: String,
    @SerializedName("runDepartureStation")
    var runDepartureStation: String,
    @SerializedName("trainNumber")
    var trainNumber: String,
    @SerializedName("travelTimeInSeconds")
    var travelTimeInSeconds: String
)