package com.example.cleanarchitecturetemplate.features.template

import com.example.cleanarchitecturetemplate.R
import com.example.cleanarchitecturetemplate.base.framework.BaseFragment

class TemplateFeatureFragment : BaseFragment<TemplateFeatureViewModel>() {

    override fun getViewModelClass(): Class<TemplateFeatureViewModel> =
        TemplateFeatureViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_template


}