package com.example.cleanarchitecturetemplate.features.template

import android.app.Application
import com.example.cleanarchitecturetemplate.base.framework.BaseViewModel
import javax.inject.Inject

class TemplateFeatureViewModel @Inject constructor(private val app: Application) :
    BaseViewModel(app) {

}