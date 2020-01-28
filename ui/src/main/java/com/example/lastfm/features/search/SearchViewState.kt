package com.example.lastfm.features.search

import com.example.domain.entites.Artist

sealed class SearchViewState {

    object StartScreen : SearchViewState()
    object Loading : SearchViewState()
    object NoResults : SearchViewState()
    object Error : SearchViewState()
    data class DataReady(val artists: List<Artist>) : SearchViewState()
}