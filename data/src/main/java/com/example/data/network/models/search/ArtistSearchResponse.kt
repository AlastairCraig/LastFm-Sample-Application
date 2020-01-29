package com.example.data.network.models.search


import com.google.gson.annotations.SerializedName

data class ArtistSearchResponse(
    @SerializedName("results")
    val results: Results
)