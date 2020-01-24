package com.example.cleanarchitecturetemplate.base

import com.example.cleanarchitecturetemplate.base.di.AppComponent
import com.example.cleanarchitecturetemplate.base.di.DaggerAppComponent
import com.example.cleanarchitecturetemplate.base.framework.BaseApplication
import com.example.data.di.NetworkModule

open class TemplateApplication : BaseApplication() {

    override val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .network(NetworkModule())
            .build()
    }
}