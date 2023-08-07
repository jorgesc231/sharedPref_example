package com.example.sharedpref_example

import android.app.Application

class sharedPrefExampleApplication : Application() {

    companion object {
        lateinit var prefs : SPrefsHelper
    }

    override fun onCreate() {
        super.onCreate()

        prefs = SPrefsHelper(applicationContext)
    }

}