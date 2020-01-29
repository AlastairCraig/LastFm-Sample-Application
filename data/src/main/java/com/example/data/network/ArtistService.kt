package com.example.data.network

import com.example.data.network.models.ArtistResponse
import com.example.data.network.models.info.ArtistInfo
import com.example.data.network.models.info.InfoResponse
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class ArtistService(private val api: ArtistApi) {

    fun getArtists(query: String): Single<List<ArtistResponse>> {
        return api.getArtists(query).map { it.results.artistmatches.artist }
    }

    fun getArtistInfo(artistName: String) : Single<ArtistInfo>{
        return api.getArtistInfo(artistName).map { it.artistInfo }
    }
}