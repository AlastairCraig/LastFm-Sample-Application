package com.example.lastfm.features.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.lastfm.R
import com.example.lastfm.base.framework.BaseFragment

class SearchFragment : BaseFragment<SearchViewModel>() {

    override fun getViewModelClass(): Class<SearchViewModel> =
        SearchViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, Observer {
            when (it) {
                is SearchViewState.Loading -> showLoadingScreen()
                is SearchViewState.Error -> showErrorDialog()
                is SearchViewState.NoResults -> showEmptyListView()
                is SearchViewState.DataReady -> showList(it)
            }
        })

        viewModel.getData()
    }

    private fun showList(data: SearchViewState.DataReady) {

    }

    private fun showEmptyListView() {

    }

    private fun showErrorDialog() {

    }

    private fun showLoadingScreen() {

    }
}