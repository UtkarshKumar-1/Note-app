package com.example.notes

import android.app.Application
import com.example.notes.di.DataModule
import com.example.notes.di.DomainModule
import com.example.notes.di.UiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                DataModule,
                DomainModule,
                UiModule
            )
        }
    }
}