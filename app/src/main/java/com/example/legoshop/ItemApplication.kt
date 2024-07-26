package com.example.legoshop

import android.app.Application
import com.example.legoshop.data.di.AppModule
import com.example.legoshop.data.di.AppModuleImpl

/**
 * Application class accessible to all activities
 */
class ItemApplication: Application() {
    /**
     * [AppModule] instance used by all classes to obtain dependencies
     */

    lateinit var appModule: AppModule


    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}