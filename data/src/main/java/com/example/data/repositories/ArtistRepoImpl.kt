package com.example.data.repositories

import com.example.data.network.ArtistService
import com.example.data.network.models.toArtistDomain
import com.example.domain.entites.Artist
import com.example.domain.repositories.ArtistRepo
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class ArtistRepoImpl(private val artistSearchService: ArtistService) : ArtistRepo {

    override fun getArtists(query: String): Single<List<Artist>> {
        return artistSearchService.getArtists(query).map { it.toArtistDomain() }
    }
}