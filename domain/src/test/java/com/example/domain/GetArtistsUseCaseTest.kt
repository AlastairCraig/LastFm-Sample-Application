package com.example.domain

import com.example.domain.DomainTestData.Companion.ARTIST_NAME
import com.example.domain.DomainTestData.Companion.LIST_OF_ARTISTS

import com.example.domain.repositories.ArtistRepo
import com.example.domain.usecases.GetArtistsUseCase
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class GetArtistsUseCaseTest {

    private lateinit var repo: ArtistRepo
    private lateinit var useCase: GetArtistsUseCase
    private lateinit var testSubscriber: TestObserver<Any>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        repo = mock(ArtistRepo::class.java)
        useCase = GetArtistsUseCase(repo)
        testSubscriber = TestObserver()
    }

    @Test
    fun `get artists use case test`() {
        val testResponse = Single.just(LIST_OF_ARTISTS)
        whenever(repo.getArtists(ARTIST_NAME)).thenReturn(testResponse)

        useCase.execute(ARTIST_NAME).subscribeWith(testSubscriber)

        Mockito.verify(repo, Mockito.times(1)).getArtists(ARTIST_NAME)
        Mockito.verifyNoMoreInteractions(repo)

        testSubscriber.assertComplete()
    }
}