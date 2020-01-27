package com.example.lastfm.base.di.modules

import com.example.lastfm.MainActivity
import com.example.lastfm.base.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity
}