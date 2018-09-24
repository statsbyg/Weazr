package com.jonecx.weazr.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherService {
    companion object {
        const val baseUrl = "https://samples.openweathermap.org/data/2.5/"
        const val apiKey = "248fb9a557c04ce95a8c7c71efaa4800"

        const val weatherByCityIdPath = "weather?id=2172797&appid=$apiKey"

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
//        val weatherService = retrofit.create(WeatherServiceClient::class.java)
    }

    fun getWeathearServiceClient() : WeatherServiceClient {
        return retrofit.create(WeatherServiceClient::class.java)
    }
}