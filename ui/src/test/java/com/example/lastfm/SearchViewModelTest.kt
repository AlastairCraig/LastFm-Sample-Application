package com.example.lastfm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.entites.Artist
import com.example.domain.usecases.GetArtistsUseCase
import com.example.lastfm.UITestData.Companion.ARTIST_NAME
import com.example.lastfm.UITestData.Companion.EMPTY_LIST_OF_ARTISTS
import com.example.lastfm.UITestData.Companion.LIST_OF_ARTISTS
import com.example.lastfm.features.search.SearchViewModel
import com.example.lastfm.features.search.SearchViewState
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class SearchViewModelTest : BaseUnitTest() {

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private var getArtistsUseCase: GetArtistsUseCase = mock()

    private lateinit var observer: Observer<SearchViewState>
    private val actualStateValues = mutableListOf<SearchViewState>()

    private val viewModel = SearchViewModel(getArtistsUseCase)

    @Before
    fun beforeEach() {

        observer = spy(Observer {
            it ?: return@Observer
            actualStateValues.plusAssign(it)
        })
    }

    @After
    fun afterEach() {

        actualStateValues.clear()
    }

    @Test
    fun `start screen is shown`() {

        viewModel.state.observeForever(observer)
        viewModel.enableStartState()

        assertEquals(SearchViewState.StartScreen, actualStateValues[0])
    }

    @Test
    fun `list of artists is loaded`() {

        val testResponse = Single.just(LIST_OF_ARTISTS)
        whenever(getArtistsUseCase.execute(ARTIST_NAME)).thenReturn(testResponse)

        viewModel.state.observeForever(observer)
        viewModel.getArtists(ARTIST_NAME)

        assertEquals(SearchViewState.Loading, actualStateValues[0])
        assertEquals(SearchViewState.DataReady(LIST_OF_ARTISTS), actualStateValues[1])
    }

    @Test
    fun `no results state shown when no data returned`() {

        val testResponse = Single.just(EMPTY_LIST_OF_ARTISTS)
        whenever(getArtistsUseCase.execute(ARTIST_NAME)).thenReturn(testResponse)

        viewModel.state.observeForever(observer)
        viewModel.getArtists(ARTIST_NAME)

        assertEquals(SearchViewState.Loading, actualStateValues[0])
        assertEquals(SearchViewState.NoResults, actualStateValues[1])
    }

    @Test
    fun `error dialog shown on error`() {

        val testResponse = Single.error<List<Artist>>(Throwable("error"))
        whenever(getArtistsUseCase.execute(ARTIST_NAME)).thenReturn(testResponse)

        viewModel.state.observeForever(observer)
        viewModel.getArtists(ARTIST_NAME)

        assertEquals(SearchViewState.Loading, actualStateValues[0])
        assertEquals(SearchViewState.Error, actualStateValues[1])
    }
}