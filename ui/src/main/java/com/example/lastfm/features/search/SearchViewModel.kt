package com.example.lastfm.features.search

import android.app.Application
import androidx.lifecycle.MutableLiveData
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

    fun enableStartState(){
        state.value = SearchViewState.StartScreen
    }

    fun getData() {
        val QUERY = "cher"

        val disposable = getArtistsUseCase.execute(QUERY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        addDisposable(disposable)
    }
}