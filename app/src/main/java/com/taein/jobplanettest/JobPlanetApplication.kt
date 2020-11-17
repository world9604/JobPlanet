package com.taein.jobplanettest

import android.app.Application
import com.facebook.stetho.Stetho

class JobPlanetApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}