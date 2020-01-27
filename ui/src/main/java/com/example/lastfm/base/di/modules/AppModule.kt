package com.example.lastfm.base.di.modules

import android.app.Application
import android.content.Context
import com.example.data.di.NetworkModule
import com.example.data.di.RepoModule
import com.example.lastfm.base.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(
    includes = [
        (NetworkModule::class),
        (RepoModule::class),
        (ViewModelModule::class),
        (UseCaseModule::class)
    ]
)
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}