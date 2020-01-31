package com.example.data

import com.example.data.network.models.info.*
import com.example.data.network.models.search.*
import com.example.domain.entites.Artist
import com.example.domain.entites.ArtistInfo

class DataTestData {

    companion object {

        private const val test_string = "test string"

        const val ARTIST_NAME: String = "Cher"
        private const val LISTENERS: String = "1157349"
        private const val IMAGE_URL: String =
            "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png"


        //Search Response Data
        private val artistResponse =
            ArtistResponse(
                ARTIST_NAME, LISTENERS, test_string, test_string, test_string, listOf(
                    SearchImage(
                        IMAGE_URL, test_string
                    )
                )
            )
        val MOCK_LIST_OF_ARTIST_RESPONSES: List<ArtistResponse> =
            listOf(artistResponse, artistResponse, artistResponse)
        private val artistMatches = Artistmatches(MOCK_LIST_OF_ARTIST_RESPONSES)
        private val openSearchQuery =
            OpensearchQuery(test_string, test_string, test_string, test_string)
        private val attr = Attr(test_string)
        private val results =
            Results(openSearchQuery, test_string, test_string, test_string, artistMatches, attr)
        val MOCK_SEARCH_RESPONSE = ArtistSearchResponse(results)

        private val mockArtist = Artist(ARTIST_NAME, IMAGE_URL, LISTENERS)
        val MOCK_ARTIST_LIST = listOf(mockArtist, mockArtist, mockArtist)


        //Info Response Data
        private const val summary: String =
            "Cher (born Cherilyn Sarkisian; May 20, 1946) is an Oscar- and Grammy-winning American singer and actress. A major figure for over five decades in the world of popular culture, " +
                    "she is often referred to as the Goddess of Pop for having first brought the sense of female autonomy and self-actualization into the entertainment industry. \\n\\nShe is known " +
                    "for her distinctive contralto and for having worked extensively across media, as well as for continuously reinventing both her music and image, the latter of which has been known to induce controversy."

        private val bio = Bio(
            Links(Link(test_string, test_string, test_string)),
            test_string,
            summary,
            test_string
        )

        private val infoImage = InfoImage(IMAGE_URL, test_string)
        val MOCK_ARTIST_INFO_RESPONSE =
            ArtistInfoResponse(
                ARTIST_NAME, test_string, test_string, listOf(
                    infoImage, infoImage, infoImage, infoImage
                ), test_string, test_string, Stats(
                    test_string, test_string
                ), Similar(listOf()), Tags(listOf()), bio
            )
        val MOCK_INFO_RESPONSE = InfoResponse(MOCK_ARTIST_INFO_RESPONSE)
        val MOCK_ARTIST_INFO = ArtistInfo(ARTIST_NAME, IMAGE_URL, summary)
    }
}