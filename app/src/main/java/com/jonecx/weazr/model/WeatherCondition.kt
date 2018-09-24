package com.jonecx.weazr.model

import com.google.gson.annotations.SerializedName

data class WeatherCondition(@SerializedName("id") val id: Int,
                            @SerializedName("main") val weatherConditionName: String,
                            @SerializedName("description") val weatherDescription: String,
                            @SerializedName("icon") val iconId: String)