package com.example.lastfm.features.template

import com.example.lastfm.R
import com.example.lastfm.base.framework.BaseFragment

class TemplateFeatureFragment : BaseFragment<TemplateFeatureViewModel>() {

    override fun getViewModelClass(): Class<TemplateFeatureViewModel> =
        TemplateFeatureViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_template


}