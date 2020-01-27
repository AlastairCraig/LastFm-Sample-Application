package com.example.lastfm.base

import com.example.lastfm.base.di.AppComponent
import com.example.lastfm.base.di.DaggerAppComponent
import com.example.lastfm.base.framework.BaseApplication
import com.example.data.di.NetworkModule

open class LastFmApplication : BaseApplication() {

    override val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .network(NetworkModule())
            .build()
    }
}