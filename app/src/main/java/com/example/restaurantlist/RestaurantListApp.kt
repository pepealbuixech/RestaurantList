package com.example.restaurantlist

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RestaurantListApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // start Koin context
        startKoin {
            androidLogger()
            androidContext(this@RestaurantListApp)
            modules(appModule)
        }
    }
}