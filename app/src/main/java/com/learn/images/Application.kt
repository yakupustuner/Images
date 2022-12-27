package com.learn.images

import android.app.Application
import com.learn.images.di.Module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(Module)
        }
    }
}