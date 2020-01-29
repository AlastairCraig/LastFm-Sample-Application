package com.example.data.network.models.info


import com.google.gson.annotations.SerializedName

data class SimilarArtist(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("image")
    val images: List<SimilarArtistImage>
)