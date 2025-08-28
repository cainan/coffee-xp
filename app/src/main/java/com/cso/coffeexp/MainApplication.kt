package com.cso.coffeexp

import android.app.Application
import com.cso.coffeexp.core.di.AppModules.dataModule
import com.cso.coffeexp.core.di.AppModules.domainModule
import com.cso.coffeexp.core.di.AppModules.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

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