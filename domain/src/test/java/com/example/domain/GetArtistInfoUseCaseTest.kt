package com.example.domain

import com.example.domain.DomainTestData.Companion.ARTIST_NAME
import com.example.domain.DomainTestData.Companion.MOCK_ARTIST_INFO
import com.example.domain.repositories.ArtistRepo
import com.example.domain.usecases.GetArtistInfoUseCase
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class GetArtistInfoUseCaseTest {

    private lateinit var repo: ArtistRepo
    private lateinit var useCase: GetArtistInfoUseCase
    private lateinit var testSubscriber: TestObserver<Any>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        repo = mock(ArtistRepo::class.java)
        useCase = GetArtistInfoUseCase(repo)
        testSubscriber = TestObserver()
    }

    @Test
    fun `get artist info use case test`() {
        val testResponse = Single.just(MOCK_ARTIST_INFO)
        whenever(repo.getArtistInfo(ARTIST_NAME)).thenReturn(testResponse)

        useCase.execute(ARTIST_NAME).subscribeWith(testSubscriber)

        Mockito.verify(repo, Mockito.times(1)).getArtistInfo(ARTIST_NAME)
        Mockito.verifyNoMoreInteractions(repo)

        testSubscriber.assertComplete()
    }
}