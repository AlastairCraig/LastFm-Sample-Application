package com.example.lastfm.base.di.modules

import com.example.lastfm.base.di.scopes.SearchScope
import com.example.lastfm.features.search.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector()
    @SearchScope
    abstract fun contributeSearchFragment(): SearchFragment
}