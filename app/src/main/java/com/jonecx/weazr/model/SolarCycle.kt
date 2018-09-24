package com.jonecx.weazr.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class SolarCycle(@SerializedName("id") val solarCycleId: Int,
                      @SerializedName("type") val solarCycleType: Int,
                      @SerializedName("message") val solarCycleMessage: Double,
                      @SerializedName("country") val solarCyclePlace: String,
                      @SerializedName("sunrise") val sunriseTime: Long,
                      @SerializedName("sunset") val sunsetTime: Long)