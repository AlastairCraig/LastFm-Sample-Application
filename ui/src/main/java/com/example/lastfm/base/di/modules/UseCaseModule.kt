package com.example.lastfm.base.di.modules

import com.example.domain.repositories.ArtistRepo
import com.example.domain.usecases.GetArtistInfoUseCase
import com.example.domain.usecases.GetArtistsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetArtistsUseCase(repo: ArtistRepo): GetArtistsUseCase {
        return GetArtistsUseCase(repo)
    }

    @Provides
    fun provideGetArtistInfoUseCase(repo: ArtistRepo): GetArtistInfoUseCase {
        return GetArtistInfoUseCase(repo)
    }
}