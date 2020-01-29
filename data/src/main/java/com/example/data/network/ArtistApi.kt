package com.example.data.network

import com.example.data.network.models.ArtistSearchResponse
import com.example.data.network.models.info.InfoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistApi {

    companion object {
        const val SEARCH_ENDPOINT = "?method=artist.search"
        const val INFO_ENDPOINT = "?method=artist.getinfo"
    }

    @GET(SEARCH_ENDPOINT)
    fun getArtists(@Query("artist") query: String): Single<ArtistSearchResponse>

    @GET(INFO_ENDPOINT)
    fun getArtistInfo(@Query("artist") artistName: String): Single<InfoResponse>
}