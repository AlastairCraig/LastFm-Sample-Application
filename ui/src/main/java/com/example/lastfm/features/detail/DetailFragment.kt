package com.example.lastfm.features.detail

import com.example.lastfm.R
import com.example.lastfm.base.framework.BaseFragment

class DetailFragment : BaseFragment<DetailViewModel>(){

    override fun getViewModelClass(): Class<DetailViewModel> =
        DetailViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_detail
}