package com.example.data.network.models.search


import com.google.gson.annotations.SerializedName

data class Artistmatches(
    @SerializedName("artist")
    val artist: List<ArtistResponse>
)