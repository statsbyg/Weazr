package com.jonecx.weazr.client

import android.Manifest
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.jonecx.weazr.ui.HomeLocationListener
import java.util.*


class LocationService: LifecycleObserver, LocationListener  {

    lateinit var lifeCycleOwner: LifecycleOwner
    lateinit var context: Context
    lateinit var locationManager: LocationManager
    lateinit var homeLocationListener: HomeLocationListener

    fun startLocationService(lifecycleOwner: LifecycleOwner, homeLocationListener: HomeLocationListener, context:Context) {
        this.lifeCycleOwner = lifecycleOwner
        this.context = context
        this.homeLocationListener = homeLocationListener
        this.locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        lifecycleOwner.lifecycle.addObserver(this)
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun addLocationListener() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
/*            locationManager.requestLocationUpdates(Context.LOCATION_SERVICE, 0L, 0f, this)
            var location : Location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER) as Location
            onLocationChanged(location)*/
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun removeLocationListener() {
         locationManager.removeUpdates(this)

    }

    override fun onLocationChanged(location: Location?) {
        var geoCoder = Geocoder(context, Locale.getDefault())
        var postalCode: String = (geoCoder.getFromLocation(location?.latitude ?: 0.0, location?.longitude ?: 0.0, 1)[0].postalCode) ?: ""
        homeLocationListener.onLocationReady(postalCode)
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }
}