package com.example.cleanarchitecturetemplate.base.di.modules

import com.example.cleanarchitecturetemplate.MainActivity
import com.example.cleanarchitecturetemplate.base.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity
}