package com.jonecx.weazr

import android.app.Application
import com.jonecx.weazr.di.appModule
import org.koin.android.ext.android.startKoin


class WeazrApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}