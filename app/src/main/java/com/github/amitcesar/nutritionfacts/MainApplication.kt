package com.github.amitcesar.nutritionfacts

import android.app.Application
import com.github.amitcesar.nutritionfacts.core.di.AppModules
import com.github.amitcesar.nutritionfacts.core.di.AppModules.dataModule
import com.github.amitcesar.nutritionfacts.core.di.AppModules.domainModule
import com.github.amitcesar.nutritionfacts.core.di.AppModules.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                uiModule,
                domainModule,
                dataModule
            )
        }
    }
}