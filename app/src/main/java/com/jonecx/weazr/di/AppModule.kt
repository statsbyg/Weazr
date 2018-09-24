package com.jonecx.weazr.di

import com.jonecx.weazr.client.WeatherService
import com.jonecx.weazr.client.WeatherServiceClient
import org.koin.dsl.module.module

var appModule = module {
    single { WeatherService() }
}