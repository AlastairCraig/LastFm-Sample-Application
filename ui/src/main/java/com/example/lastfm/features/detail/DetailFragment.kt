package com.example.lastfm.features.detail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import com.example.lastfm.R
import com.example.lastfm.base.framework.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.view_detail.*

class DetailFragment : BaseFragment<DetailViewModel>() {

    override fun getViewModelClass(): Class<DetailViewModel> =
        DetailViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, Observer {
            when (it) {

                is DetailViewState.Loading -> showLoadingScreen()
                is DetailViewState.Error -> showErrorDialog()
                is DetailViewState.DataReady -> showDetailView(it)
            }
        })
        viewModel.getArtistInfoData()
    }

    private fun showLoadingScreen() {

        loading_screen.visibility = View.VISIBLE
        detail_screen.visibility = View.GONE
    }

    private fun showErrorDialog() {

    }

    private fun showDetailView(data: DetailViewState.DataReady) {

        detail_screen.visibility = View.VISIBLE
        loading_screen.visibility = View.GONE
        artist_name.text = data.info.name
        summary.text = data.info.summary
        loadlImage(data.info.imageUrl, artist_image)
    }

    private fun loadlImage(url: String?, imageView: ImageView) =
        if (url == null || url.isEmpty()) {

            imageView.setImageResource(R.drawable.ic_error)
        } else {

            Picasso.get()
                .load(url)
                .error(R.drawable.ic_error)
                .into(imageView)
        }
}