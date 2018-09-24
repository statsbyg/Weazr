package com.jonecx.weazr.model

import com.google.gson.annotations.SerializedName

data class WeatherDetail(@SerializedName("temp") val temperature: Double,
                         @SerializedName("pressure") val pressure: Double,
                         @SerializedName("humidity") val humidity: Double,
                         @SerializedName("temp_min") val minTemperature: Double,
                         @SerializedName("temp_max") val maxTempearture: Double)