package com.example.lastfm

import com.example.domain.entites.Artist

class UITestData {

    companion object {

        const val ARTIST_NAME: String = "Cher"
        const val LISTENERS: String = "1157349"
        const val IMAGE_URL: String =
            "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png"

        val MOCK_ARTIST = Artist(ARTIST_NAME, IMAGE_URL, LISTENERS)

        val LIST_OF_ARTISTS: List<Artist> = listOf(MOCK_ARTIST, MOCK_ARTIST, MOCK_ARTIST)
        val EMPTY_LIST_OF_ARTISTS: List<Artist> = listOf()
    }
}