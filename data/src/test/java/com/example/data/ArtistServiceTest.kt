package com.example.data

import com.example.data.DataTestData.Companion.ARTIST_INFO_RESPONSE
import com.example.data.DataTestData.Companion.ARTIST_NAME
import com.example.data.DataTestData.Companion.LIST_OF_ARTIST_RESPONSES
import com.example.data.DataTestData.Companion.MOCK_INFO_RESPONSE
import com.example.data.DataTestData.Companion.MOCK_SEARCH_RESPONSE
import com.example.data.network.ArtistApi
import com.example.data.network.ArtistService
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test

class ArtistServiceTest {

    private val api: ArtistApi = mock()

    private lateinit var artistService: ArtistService
    private lateinit var testSubscriber: TestObserver<Any>
    
    @Before
    fun setUp() {
        artistService = ArtistService(api)
        testSubscriber = TestObserver()
    }

    @Test
    fun `get artists from service test`() {

        given { api.getArtists(ARTIST_NAME) }
            .willReturn(Single.just(MOCK_SEARCH_RESPONSE))

        artistService.getArtists(ARTIST_NAME).subscribe(testSubscriber)

        testSubscriber.assertValue(LIST_OF_ARTIST_RESPONSES)
        testSubscriber.assertComplete()
    }

    @Test
    @Throws(Exception::class)
    fun `get artist info from service test`() {

        given { api.getArtistInfo(ARTIST_NAME) }
            .willReturn(Single.just(MOCK_INFO_RESPONSE))

        artistService.getArtistInfo(ARTIST_NAME).subscribe(testSubscriber)

        testSubscriber.assertValue(ARTIST_INFO_RESPONSE)
        testSubscriber.assertComplete()
    }
}