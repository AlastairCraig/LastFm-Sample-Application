package com.example.lastfm.base.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lastfm.features.template.TemplateFeatureViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TemplateFeatureViewModel::class)
    internal abstract fun bindsTemplateFeatureViewModel(templateFeatureViewModel: TemplateFeatureViewModel): ViewModel
}