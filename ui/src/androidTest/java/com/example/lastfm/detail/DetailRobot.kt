package com.example.lastfm.detail

import com.example.lastfm.R
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions

class DetailRobot {

    fun checkDetailInformation() = apply {
        BaristaVisibilityAssertions.assertDisplayed(artistName)
        BaristaVisibilityAssertions.assertDisplayed(artistImageView)

    }

    fun short_wait() = apply {
        Thread.sleep(4000)
    }

    companion object {

        private const val artistName = "Cher"
        private const val artistImageView = R.id.artist_image
    }


}