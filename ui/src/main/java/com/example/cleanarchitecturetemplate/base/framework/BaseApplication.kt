package com.example.cleanarchitecturetemplate.base.framework

import com.example.cleanarchitecturetemplate.base.di.AppComponent
import dagger.android.support.DaggerApplication

abstract class BaseApplication : DaggerApplication() {

    abstract val appComponent: AppComponent

    override fun applicationInjector() = appComponent
}