package com.example.lastfm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.domain.entites.ArtistInfo
import com.example.domain.usecases.GetArtistInfoUseCase
import com.example.lastfm.UITestData.Companion.ARTIST_NAME
import com.example.lastfm.UITestData.Companion.MOCK_ARTIST_INFO
import com.example.lastfm.features.detail.DetailViewModel
import com.example.lastfm.features.detail.DetailViewState
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

class DetailViewModelTest : BaseUnitTest() {

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private var getArtistInfoUseCase: GetArtistInfoUseCase = mock()

    private lateinit var observer: Observer<DetailViewState>
    private val actualStateValues = mutableListOf<DetailViewState>()

    private val viewModel = DetailViewModel(getArtistInfoUseCase)

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
    fun `artist info is loaded`() {

        val testResponse = Single.just(MOCK_ARTIST_INFO)
        whenever(getArtistInfoUseCase.execute(ARTIST_NAME)).thenReturn(testResponse)

        viewModel.state.observeForever(observer)
        viewModel.getArtistInfoData(ARTIST_NAME)

        assertEquals(DetailViewState.Loading, actualStateValues[0])
        assertEquals(DetailViewState.DataReady(MOCK_ARTIST_INFO), actualStateValues[1])
    }

    @Test
    fun `artist info error`() {

        val testResponse = Single.error<ArtistInfo>(Throwable("error"))
        whenever(getArtistInfoUseCase.execute(ARTIST_NAME)).thenReturn(testResponse)

        viewModel.state.observeForever(observer)
        viewModel.getArtistInfoData(ARTIST_NAME)

        assertEquals(DetailViewState.Loading, actualStateValues[0])
        assertEquals(DetailViewState.Error, actualStateValues[1])
    }
}