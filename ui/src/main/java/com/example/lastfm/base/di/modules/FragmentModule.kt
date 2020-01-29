package com.example.lastfm.base.di.modules

import com.example.lastfm.base.di.scopes.SearchScope
import com.example.lastfm.features.detail.DetailFragment
import com.example.lastfm.features.search.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector()
    @SearchScope
    abstract fun contributeSearchFragment(): SearchFragment

    @ContributesAndroidInjector()
    @SearchScope
    abstract fun contributeDetailFragment(): DetailFragment
}