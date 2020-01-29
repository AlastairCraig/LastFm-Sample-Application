package com.example.lastfm.features.search.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.domain.entites.Artist
import com.example.lastfm.R
import com.example.lastfm.base.framework.BaseFragment
import com.example.lastfm.features.search.SearchViewModel
import com.example.lastfm.features.search.SearchViewState
import com.miguelcatalan.materialsearchview.MaterialSearchView
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment<SearchViewModel>(), ArtistItemClickListener {

    private lateinit var mQuery: String

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
        viewModel.enableStartState()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        val item: MenuItem = menu.findItem(R.id.action_search)
        search_view.setMenuItem(item)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onArtistItemClicked(artist: Artist) {
        Toast.makeText(activity, "clicked", Toast.LENGTH_SHORT).show()
    }

    private fun showStartScreen() {

        start_screen.visibility = View.VISIBLE
        recycler_view.visibility = View.GONE
        no_results_screen.visibility = View.GONE
        loading_screen.visibility = View.GONE
    }

    private fun showList(data: SearchViewState.DataReady) {

        recycler_view.visibility = View.VISIBLE
        start_screen.visibility = View.GONE
        no_results_screen.visibility = View.GONE
        loading_screen.visibility = View.GONE
        setupRecyclerView(data.artists)
    }

    private fun setupRecyclerView(artistList: List<Artist>) {

        val artistListAdapter = ArtistListAdapter(artistList, this)
        recycler_view.apply {
            adapter = artistListAdapter
        }
    }

    private fun showEmptyListView() {

        no_results_screen.visibility = View.VISIBLE
        start_screen.visibility = View.GONE
        recycler_view.visibility = View.GONE
        loading_screen.visibility = View.GONE
    }

    private fun showErrorDialog() {

        val errorDialog = AlertDialog.Builder(activity)
            .setTitle(getString(R.string.error_title))
            .setMessage(getString(R.string.error_message))
            .setPositiveButton(getString(R.string.error_button_text)) { dialog, _ ->
                dialog.dismiss()
                viewModel.getArtists(mQuery)
            }
            .create()
        errorDialog.show()
    }

    private fun showLoadingScreen() {

        loading_screen.visibility = View.VISIBLE
        no_results_screen.visibility = View.GONE
        start_screen.visibility = View.GONE
        recycler_view.visibility = View.GONE
    }

    private fun setUpSearchView() {

        search_view.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getArtists(query)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                mQuery = query
                if (query.isEmpty()) {
                    viewModel.enableStartState()
                }
                if (query.length > 2) {
                    viewModel.getArtists(query)
                }
                return false
            }
        })
    }
}