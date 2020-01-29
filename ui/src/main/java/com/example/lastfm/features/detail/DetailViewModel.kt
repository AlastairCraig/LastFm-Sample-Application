package com.example.lastfm.features.detail

import androidx.lifecycle.MutableLiveData
import com.example.domain.usecases.GetArtistInfoUseCase
import com.example.lastfm.base.framework.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val getArtistInfoUseCase: GetArtistInfoUseCase
) :
    BaseViewModel() {

    val state: MutableLiveData<DetailViewState> = MutableLiveData()

    fun getArtistInfoData(artistName: String) {
        state.value = DetailViewState.Loading

        val disposable = getArtistInfoUseCase.execute(artistName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { artistInfo ->
                    state.value = DetailViewState.DataReady(artistInfo)
                },
                { error ->
                    state.value = DetailViewState.Error
                })
        addDisposable(disposable)
    }
}