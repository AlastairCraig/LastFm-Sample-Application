package com.example.lastfm.features.search

import com.example.lastfm.R
import com.example.lastfm.base.framework.BaseFragment

class SearchFragment : BaseFragment<SearchViewModel>() {

    override fun getViewModelClass(): Class<SearchViewModel> =
        SearchViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_search


}