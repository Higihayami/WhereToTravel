package com.example.wheretotravel.presentation.api.response


import com.google.gson.annotations.SerializedName

data class RidesResponseJson(
    @SerializedName("trips")
    var trips: List<Trip>,
    @SerializedName("url")
    var url: String
)