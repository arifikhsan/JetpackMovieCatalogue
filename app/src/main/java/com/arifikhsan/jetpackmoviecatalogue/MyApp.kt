package com.arifikhsan.jetpackmoviecatalogue

import android.app.Application
import com.arifikhsan.jetpackmoviecatalogue.injection.appModules
import com.arifikhsan.jetpackmoviecatalogue.injection.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startInjection()
    }

    private fun startInjection() {
        val moduleList = listOf(appModules, viewModelModules)

        startKoin {
            androidContext(this@MyApp)
            modules(moduleList)
        }
    }
}
