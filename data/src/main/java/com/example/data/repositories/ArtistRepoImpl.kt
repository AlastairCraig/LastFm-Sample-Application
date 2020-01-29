package com.example.data.repositories

import com.example.data.network.ArtistService
import com.example.data.network.models.info.toArtistInfoDomain
import com.example.data.network.models.search.toArtistDomain
import com.example.domain.entites.Artist
import com.example.domain.entites.ArtistInfo
import com.example.domain.repositories.ArtistRepo
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class ArtistRepoImpl(private val artistService: ArtistService) : ArtistRepo {

    override fun getArtists(query: String): Single<List<Artist>> {
        return artistService.getArtists(query).map { it.toArtistDomain() }
    }

    override fun getArtistInfo(artistName: String): Single<ArtistInfo> {
        return artistService.getArtistInfo(artistName).map { it.toArtistInfoDomain()}
    }
}