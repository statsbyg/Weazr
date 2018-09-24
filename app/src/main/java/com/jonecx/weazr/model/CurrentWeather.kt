package com.jonecx.weazr.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class CurrentWeather(@SerializedName("id") val currentWeatherId: Int,
                          @SerializedName("name") val locationName: String,
                          @SerializedName("cod") val code: Int,
                          @SerializedName("dt") val date: Long,
                          @SerializedName("visibility") val visibility: Int,
                          @SerializedName("base") val baseStationName: String,
                          @SerializedName("coord") val locationCoordinate: Location,
                          @SerializedName("weather") val weatherCondtion: Array<WeatherCondition>,
                          @SerializedName("main") val weatherDetail: WeatherDetail,
                          @SerializedName("wind") val wind: Wind,
                          @SerializedName("clouds") val cloud: Cloud,
                          @SerializedName("sys") val solarCycle: SolarCycle)