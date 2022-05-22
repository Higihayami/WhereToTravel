package com.example.wheretotravel.presentation.api

import com.example.wheretotravel.presentation.api.response.RidesResponseJson
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("https://suggest.travelpayouts.com/search?service=tutu_trains")
    suspend fun getRides(@Query("term") cityDeparture: String, @Query("term2") cityArrival: String,@Query("date")date: String): RidesResponseJson
}