package com.example.wheretotravel.app

import android.app.Application
import com.example.wheretotravel.di.AppComponent
import com.example.wheretotravel.di.AppModule
import com.example.wheretotravel.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}