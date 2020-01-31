package com.example.lastfm

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchTest {

    @get:Rule
    val homeActivity = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testShowStartScreen() {
        SearchRobot()
            .checkStartScreenText()
    }

    @Test
    fun testShowArtistList() {
        SearchRobot()
            .openSearchView()
            .enterSearchQuery(searchQueryText)
    }

    @Test
    fun testClickingOnArtistOpensDetail() {
        SearchRobot()
            .openSearchView()
            .enterSearchQuery(searchQueryText)
            .long_wait()
            .checkArtistItemsDisplayed()
            .openArtistDetailPage()
            .short_wait()
            .checkDetailDisplayed()
    }

    @Test
    fun testNoResultsViewShown() {
        SearchRobot()
            .openSearchView()
            .enterSearchQuery(searchQueryTextNoResults)
            .short_wait()
            .checkNoResultsScreenTextShown()
    }

    companion object {

        private const val searchQueryText = "Cher"
        private const val searchQueryTextNoResults = "yfhdvbhgf"
    }
}