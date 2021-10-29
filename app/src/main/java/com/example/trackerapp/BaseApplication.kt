package com.example.trackerapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp //2//Compile time injected, that the app we want to inject dependencies using dagger
class BaseApplication: Application() { //1

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree()) //12
    }

}