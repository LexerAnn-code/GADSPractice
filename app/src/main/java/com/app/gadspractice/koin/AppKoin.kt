package com.app.gadspractice.koin

import android.app.Application
import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin

class AppKoin:Application(){
    override fun onCreate() {
        super.onCreate()
    //starting koin
        startKoin {
androidContext(this@AppKoin)
modules(viewModelModule)
            modules(netWork)
            modules(repositoryModuleApiRepository)
            modules(repositoryModuleRepositorySubmit)
            modules(repositoryModules)
            modules(repositoryModuleSubmit)

        }
    }
}