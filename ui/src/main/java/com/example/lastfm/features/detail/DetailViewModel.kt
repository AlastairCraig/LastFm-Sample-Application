package com.example.lastfm.features.detail

import androidx.lifecycle.MutableLiveData
import com.example.domain.usecases.GetArtistInfoUseCase
import com.example.lastfm.base.framework.BaseViewModel
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val getArtistInfoUseCase: GetArtistInfoUseCase
) :
    BaseViewModel() {

    val state: MutableLiveData<DetailViewState> = MutableLiveData()
}