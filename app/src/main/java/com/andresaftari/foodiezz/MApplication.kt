package com.andresaftari.foodiezz

import android.app.Application
import com.andresaftari.foodiezz.ui.injections.useCaseModule
import com.andresaftari.foodiezz.ui.injections.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MApplication)
            modules(
                listOf(

                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}