package com.example.data

import com.example.data.DataTestData.Companion.ARTIST_INFO_RESPONSE
import com.example.data.DataTestData.Companion.ARTIST_NAME
import com.example.data.DataTestData.Companion.LIST_OF_ARTIST_RESPONSES
import com.example.data.DataTestData.Companion.MOCK_ARTIST_INFO
import com.example.data.DataTestData.Companion.MOCK_ARTIST_LIST
import com.example.data.network.ArtistService
import com.example.data.repositories.ArtistRepoImpl
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test

class ArtistRepoImplTest {

    private val service: ArtistService = mock()
    private lateinit var repo: ArtistRepoImpl

    private lateinit var testSubscriber: TestObserver<Any>

    @Before
    fun setUp() {
        repo = ArtistRepoImpl(service)
        testSubscriber = TestObserver()
    }

    @Test
    fun `get artists from repo test`() {

        given { service.getArtists(ARTIST_NAME) }
            .willReturn(Single.just(LIST_OF_ARTIST_RESPONSES))

        repo.getArtists(ARTIST_NAME).subscribe(testSubscriber)

        testSubscriber.assertValue(MOCK_ARTIST_LIST)
        testSubscriber.assertComplete()
    }

    @Test
    fun `get artist info from repo test`() {

        given { service.getArtistInfo(ARTIST_NAME) }
            .willReturn(Single.just(ARTIST_INFO_RESPONSE))

        repo.getArtistInfo(ARTIST_NAME).subscribe(testSubscriber)

        testSubscriber.assertValue(MOCK_ARTIST_INFO)
        testSubscriber.assertComplete()
    }
}