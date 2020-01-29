package com.example.data.network.models.info


import com.google.gson.annotations.SerializedName

data class SimilarArtistImage(
    @SerializedName("#text")
    val text: String,
    @SerializedName("size")
    val size: String
)