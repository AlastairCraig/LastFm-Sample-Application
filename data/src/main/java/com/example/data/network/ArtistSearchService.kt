package com.example.data.network

import com.example.data.network.models.ArtistResponse
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class ArtistSearchService(private val api: ArtistApi) {

    fun getArtists(query: String): Single<List<ArtistResponse>> {
        return api.getArtists(query).map { it.results.artistmatches.artist }
    }
}