package com.example.data.di

import com.example.data.network.ArtistSearchService
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
        artistSearchService: ArtistSearchService
    ): ArtistRepo {
        return ArtistRepoImpl(artistSearchService)
    }
}