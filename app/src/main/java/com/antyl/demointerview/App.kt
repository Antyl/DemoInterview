package com.antyl.demointerview

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
internal class App: Application() {

    override fun onCreate() {
        super.onCreate()


    }
}