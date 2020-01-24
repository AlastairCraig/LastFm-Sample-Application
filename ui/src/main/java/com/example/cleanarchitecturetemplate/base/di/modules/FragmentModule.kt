package com.example.cleanarchitecturetemplate.base.di.modules

import com.example.cleanarchitecturetemplate.base.di.scopes.TemplateFeatureScope
import com.example.cleanarchitecturetemplate.features.template.TemplateFeatureFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector()
    @TemplateFeatureScope
    abstract fun contributeTemplateFeatureFragment(): TemplateFeatureFragment
}