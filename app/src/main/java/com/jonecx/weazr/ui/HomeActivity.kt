package com.jonecx.weazr.ui

import android.databinding.DataBindingUtil
import android.location.Location
import android.location.LocationListener
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jonecx.weazr.R
import com.jonecx.weazr.client.LocationService
import com.jonecx.weazr.client.WeatherService
import com.jonecx.weazr.databinding.ActivityMainBinding
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import kotlin.coroutines.experimental.CoroutineContext

interface HomeLocationListener {
    fun onLocationReady(location: String)
}

class HomeActivity : AppCompatActivity(), CoroutineScope, HomeLocationListener {

    private val weatherService by inject<WeatherService>()
    private val locationService by inject<LocationService>()

    lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loadDataFromUI(binding)
        locationService.startLocationService(this, this, applicationContext)
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    fun loadDataFromUI(binding: ActivityMainBinding) = launch {
        val getCurrentWeatherTask = async(Dispatchers.IO) {
            weatherService.getWeathearServiceClient().getCurrentWeatherById().execute().body()
        }



        binding.currentWeather = getCurrentWeatherTask.await()
    }
}
