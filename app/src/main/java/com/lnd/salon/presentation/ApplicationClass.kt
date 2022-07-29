package com.lnd.salon.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationClass:Application() {

    companion object{
        var mInstance: ApplicationClass? = null
    }

    @Synchronized
    fun getInstance(): ApplicationClass? {
        return ApplicationClass.mInstance
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }


}