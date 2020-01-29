package com.example.lastfm.features.search

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.domain.entites.Artist
import com.example.domain.usecases.GetArtistsUseCase
import com.example.lastfm.base.framework.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val app: Application,
    private val getArtistsUseCase: GetArtistsUseCase
) :
    BaseViewModel(app) {

    val state: MutableLiveData<SearchViewState> = MutableLiveData()

    fun enableStartState() {
        state.value = SearchViewState.StartScreen
    }

    fun getArtists(query: String) {

        state.value = SearchViewState.Loading

        val disposable = getArtistsUseCase.execute(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { checkListState(it) }
            .subscribe()
        addDisposable(disposable)
    }

    private fun checkListState(list: List<Artist>) {

        if (list.isEmpty()) {
            state.value = SearchViewState.NoResults
        } else {
            state.value = SearchViewState.DataReady(list)
        }
    }
}