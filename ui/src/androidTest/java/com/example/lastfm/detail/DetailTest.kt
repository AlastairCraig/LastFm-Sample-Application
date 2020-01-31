package com.example.lastfm.detail

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.lastfm.MainActivity
import com.example.lastfm.search.SearchRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailTest {

    @get:Rule
    val homeActivity = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testDetailInformationShown() {

        SearchRobot()
            .openSearchView()
            .enterSearchQuery(searchQueryText)
            .long_wait()
            .checkArtistItemsDisplayed()
            .openDetailPage()
            .short_wait()
            .checkDetailInformation()
    }

    companion object {

        private const val searchQueryText = "Cher"
    }
}