package com.example.lastfm.base.di.modules

import com.example.lastfm.base.di.scopes.TemplateFeatureScope
import com.example.lastfm.features.template.TemplateFeatureFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector()
    @TemplateFeatureScope
    abstract fun contributeTemplateFeatureFragment(): TemplateFeatureFragment
}