package com.example.data

import com.example.data.network.models.info.*
import com.example.data.network.models.search.*
import com.example.domain.entites.Artist
import com.example.domain.entites.ArtistInfo

class DataTestData {

    companion object {

        val test_string = "test string"

        const val ARTIST_NAME: String = "Cher"
        private const val LISTENERS: String = "1157349"
        private const val IMAGE_URL: String =
            "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png"

        private val MOCK_ARTIST = Artist(ARTIST_NAME, IMAGE_URL, LISTENERS)

        val LIST_OF_ARTISTS: List<Artist> = listOf(MOCK_ARTIST, MOCK_ARTIST, MOCK_ARTIST)
        val EMPTY_LIST_OF_ARTISTS: List<Artist> = listOf()


        //Search Response Data
        val MOCK_ARTIST_RESPONSE =
            ArtistResponse(ARTIST_NAME, LISTENERS, test_string, IMAGE_URL, test_string, listOf())
        val LIST_OF_ARTIST_RESPONSES: List<ArtistResponse> =
            listOf(MOCK_ARTIST_RESPONSE, MOCK_ARTIST_RESPONSE, MOCK_ARTIST_RESPONSE)
        val ARTIST_MATCHES = Artistmatches(LIST_OF_ARTIST_RESPONSES)
        private val openSearchQuery =
            OpensearchQuery(test_string, test_string, test_string, test_string)
        private val attr = Attr(test_string)
        val RESULTS =
            Results(openSearchQuery, test_string, test_string, test_string, ARTIST_MATCHES, attr)
        val MOCK_SEARCH_RESPONSE = ArtistSearchResponse(RESULTS)


        //Info Response Data
        private val bio = Bio(
            Links(Link(test_string, test_string, test_string)),
            test_string,
            test_string,
            test_string
        )
        val ARTIST_INFO_RESPONSE =
            ArtistInfoResponse(
                ARTIST_NAME, test_string, IMAGE_URL, listOf(), test_string, test_string, Stats(
                    test_string, test_string
                ), Similar(listOf()), Tags(listOf()), bio
            )
        val MOCK_INFO_RESPONSE = InfoResponse(ARTIST_INFO_RESPONSE)

        private const val ARTIST_SUMMARY: String =
            "Cher (born Cherilyn Sarkisian; May 20, 1946) is an Oscar- and Grammy-winning American singer and actress. A major figure for over five decades in the world of popular culture, " +
                    "she is often referred to as the Goddess of Pop for having first brought the sense of female autonomy and self-actualization into the entertainment industry. \\n\\nShe is known " +
                    "for her distinctive contralto and for having worked extensively across media, as well as for continuously reinventing both her music and image, the latter of which has been known to induce controversy."

        val MOCK_ARTIST_INFO = ArtistInfo(ARTIST_NAME, IMAGE_URL, ARTIST_SUMMARY)


    }
}