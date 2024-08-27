package com.example.havadurumu.api

import com.example.wheaterapp.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HavaApi {
    @GET("v1/current.json")
    suspend fun getHava(
        @Query("key")apiKey:String,
        @Query("q")city:String
    ):Response<WeatherModel>
}