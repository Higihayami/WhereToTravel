package com.example.wheretotravel.presentation.api

import com.example.wheretotravel.presentation.api.response.RidesResponseJson
import com.example.wheretotravel.presentation.api.response.Trip
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://suggest.travelpayouts.com/"

class RidesRepository {
    private val okhttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val api: Api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    suspend fun getRides(cityDeparture: String, cityArrival: String, date: String): RidesResponseJson {
        return api.getRides(cityDeparture, cityArrival, date)
    }
}