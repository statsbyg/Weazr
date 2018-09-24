package com.jonecx.weazr.model

import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("lon") val longitude: Double,
                    @SerializedName("lat") val latitude: Double)