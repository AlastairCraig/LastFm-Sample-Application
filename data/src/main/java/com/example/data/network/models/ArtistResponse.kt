package com.example.data.network.models


import com.google.gson.annotations.SerializedName

data class ArtistResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("streamable")
    val streamable: String,
    @SerializedName("image")
    val image: List<Image>
)