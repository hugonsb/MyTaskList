package com.example.notes

import android.app.Application
import com.example.notes.di.appModule
import com.example.notes.di.dbModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class TaskApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            //androidLogger(level = Level.DEBUG) //ver logs do koin
            androidContext(this@TaskApplication) //contexto para o ThemeViewModel
            modules(appModule, dbModule)
        }
    }
}
