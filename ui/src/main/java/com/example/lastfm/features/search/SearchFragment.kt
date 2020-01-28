package com.example.lastfm.features.search

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import com.example.lastfm.R
import com.example.lastfm.base.framework.BaseFragment
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment<SearchViewModel>() {

    override fun getViewModelClass(): Class<SearchViewModel> =
        SearchViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, Observer {
            when (it) {
                is SearchViewState.StartScreen -> showStartScreen()
                is SearchViewState.Loading -> showLoadingScreen()
                is SearchViewState.Error -> showErrorDialog()
                is SearchViewState.NoResults -> showEmptyListView()
                is SearchViewState.DataReady -> showList(it)
            }
        })
        setHasOptionsMenu(true)
        setUpSearchView()
        //viewModel.getData()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        val item: MenuItem = menu.findItem(R.id.action_search)
        search_view.setMenuItem(item)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun showStartScreen() {

    }

    private fun showList(data: SearchViewState.DataReady) {

    }

    private fun showEmptyListView() {

    }

    private fun showErrorDialog() {

    }

    private fun showLoadingScreen() {

    }

    private fun setUpSearchView() {
        search_view.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                //get data
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                if (query.isEmpty()) {
                    //show start state
                }
                if (query.length > 2) {
                    //get data
                }
                return false
            }
        })
    }
}