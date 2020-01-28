package com.example.data.network

import com.example.data.network.models.ArtistSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistApi {

    companion object {
        const val ENDPOINT = "?method=artist.search"
    }

    @GET(ENDPOINT)
    fun getArtists(@Query("artist") query: String): Single<ArtistSearchResponse>
}