package com.jonecx.weazr.client

import com.jonecx.weazr.model.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET

interface WeatherServiceClient {

    @GET(WeatherService.weatherByCityIdPath)
    fun getCurrentWeatherById(): Call<CurrentWeather>
}