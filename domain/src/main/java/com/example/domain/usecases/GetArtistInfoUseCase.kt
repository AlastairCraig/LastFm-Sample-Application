package com.example.domain.usecases

import com.example.domain.entites.ArtistInfo
import com.example.domain.repositories.ArtistRepo
import io.reactivex.Single

class GetArtistInfoUseCase(private val repo: ArtistRepo) {

    fun execute(artistName: String): Single<ArtistInfo> {
        return repo.getArtistInfo(artistName)
    }
}