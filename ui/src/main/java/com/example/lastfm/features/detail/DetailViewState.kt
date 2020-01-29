package com.example.lastfm.features.detail

import com.example.domain.entites.ArtistInfo

sealed class DetailViewState {

    object Loading : DetailViewState()
    object Error : DetailViewState()
    data class DataReady(val info: List<ArtistInfo>) : DetailViewState()
}