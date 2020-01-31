package com.example.domain

import com.example.domain.entites.Artist
import com.example.domain.entites.ArtistInfo

class DomainTestData {

    companion object {

        const val ARTIST_NAME: String = "Cher"
        private const val LISTENERS: String = "1157349"
        private const val IMAGE_URL: String =
            "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png"

        private val artist = Artist(ARTIST_NAME, IMAGE_URL, LISTENERS)
        val MOCK_LIST_OF_ARTISTS: List<Artist> = listOf(artist, artist, artist)

        private const val summary: String =
            "Cher (born Cherilyn Sarkisian; May 20, 1946) is an Oscar- and Grammy-winning American singer and actress. A major figure for over five decades in the world of popular culture, " +
                    "she is often referred to as the Goddess of Pop for having first brought the sense of female autonomy and self-actualization into the entertainment industry. \\n\\nShe is known " +
                    "for her distinctive contralto and for having worked extensively across media, as well as for continuously reinventing both her music and image, the latter of which has been known to induce controversy."

        val MOCK_ARTIST_INFO = ArtistInfo(ARTIST_NAME, IMAGE_URL, summary)
    }
}