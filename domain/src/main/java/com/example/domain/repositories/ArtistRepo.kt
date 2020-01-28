package com.example.domain.repositories

import com.example.domain.entites.Artist
import io.reactivex.Single

interface ArtistRepo {

    fun getArtists(query: String): Single<List<Artist>>
}