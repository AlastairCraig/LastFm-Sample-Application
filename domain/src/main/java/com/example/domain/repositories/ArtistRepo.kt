package com.example.domain.repositories

import com.example.domain.entites.Artist
import com.example.domain.entites.ArtistInfo
import io.reactivex.Single

interface ArtistRepo {

    fun getArtists(query: String): Single<List<Artist>>

    fun getArtistInfo(artistName: String): Single<ArtistInfo>
}