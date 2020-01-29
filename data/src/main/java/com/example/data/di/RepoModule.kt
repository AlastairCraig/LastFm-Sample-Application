package com.example.data.di

import com.example.data.network.ArtistService
import com.example.data.repositories.ArtistRepoImpl
import com.example.domain.repositories.ArtistRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepoModule {

    @Singleton
    @Provides
    fun provideArtistSearchRepo(
        artistSearchService: ArtistService
    ): ArtistRepo {
        return ArtistRepoImpl(artistSearchService)
    }
}