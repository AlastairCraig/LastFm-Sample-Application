package com.example.domain.usecases

import com.example.domain.entites.Artist
import com.example.domain.repositories.ArtistRepo
import io.reactivex.Single

class GetArtistsUseCase(private val repo: ArtistRepo) {

    fun execute(query: String): Single<List<Artist>> {
        return repo.getArtists(query)
    }
}