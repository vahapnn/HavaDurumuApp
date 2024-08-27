package com.example.havadurumu.retrofithelper

import com.example.havadurumu.api.HavaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL="https://api.weatherapi.com"
    private fun getInstance():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val havaApi:HavaApi=
        getInstance().create(HavaApi::class.java)
}