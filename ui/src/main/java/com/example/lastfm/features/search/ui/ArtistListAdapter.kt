package com.example.lastfm.features.search.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entites.Artist
import com.example.lastfm.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_artist.view.*

class ArtistListAdapter(
    private val artistList: List<Artist>,
    private val listener: ArtistItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArtistViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_artist,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val artistItem = artistList[position]
        when (holder) {
            is ArtistViewHolder -> {
                holder.artistName.text = artistItem.name
                holder.listeners.text = artistItem.listeners
                loadThumbnailImage(artistItem.thumbnailUrl, holder.thumbnail)
                holder.itemView.setOnClickListener {
                    listener.onArtistItemClicked(artistItem)
                }
            }
        }
    }

    private fun loadThumbnailImage(url: String?, imageView: ImageView) =
        if (url == null || url.isEmpty()) {

            imageView.setImageResource(R.drawable.ic_error)
        } else {

            Picasso.get()
                .load(url)
                .error(R.drawable.ic_error)
                .into(imageView)
        }

    inner class ArtistViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val artistName: TextView = view.artist_name
        val listeners: TextView = view.listeners
        val thumbnail: ImageView = view.thumbnail
    }
}