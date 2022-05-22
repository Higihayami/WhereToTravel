package com.example.wheretotravel.presentation.api.response


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("price")
    var price: Int,
    @SerializedName("type")
    var type: String
)