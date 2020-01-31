package com.example.lastfm

import com.schibsted.spain.barista.assertion.BaristaListAssertions
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions
import com.schibsted.spain.barista.interaction.BaristaClickInteractions
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions
import com.schibsted.spain.barista.interaction.BaristaListInteractions

class SearchRobot {

    fun checkStartScreenText() = apply {
        BaristaVisibilityAssertions.assertDisplayed(title)
        BaristaVisibilityAssertions.assertDisplayed(startScreenText)
    }

    fun openSearchView() = apply {
        BaristaClickInteractions.clickOn(searchMenuItemButton)
    }

    fun enterSearchQuery(query: String) = apply {
        BaristaEditTextInteractions.writeTo(searchBarView, query)
        BaristaClickInteractions.clickBack()
    }

    fun checkArtistItemsDisplayed() = apply {
        BaristaListAssertions.assertListItemCount(
            recyclerView,
            30
        )
        BaristaListAssertions.assertDisplayedAtPosition(
            recyclerView, 0,
            artistNameTextView, artistName
        )
    }

    fun openArtistDetailPage() = apply {
        BaristaListInteractions.clickListItem(recyclerView, 0)

    }

    fun checkDetailDisplayed() = apply {
        BaristaVisibilityAssertions.assertDisplayed(detailScreen)
    }

    fun checkNoResultsScreenTextShown() = apply {
        BaristaVisibilityAssertions.assertDisplayed(noResultsFoundText)
    }

    fun long_wait() = apply {
        Thread.sleep(10000)
    }

    fun short_wait() = apply {
        Thread.sleep(4000)
    }

    companion object {

        private const val title = "LastFm Sample Application"
        private const val startScreenText =
            "Search for Music Artists by clicking the search icon at the top"
        private const val noResultsFoundText = "No Artists Found"

        //Artist Item
        private const val artistNameTextView = R.id.artist_name
        private const val artistName = "Cher"

        private const val searchMenuItemButton = R.id.action_search
        private const val searchBarView = R.id.search_view
        private const val recyclerView = R.id.recycler_view

        private const val detailScreen = R.id.detail_screen
    }
}