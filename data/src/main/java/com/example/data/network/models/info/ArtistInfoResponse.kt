package com.example.data.network.models.info


import com.google.gson.annotations.SerializedName

data class ArtistInfoResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("image")
    val image: List<Image>,
    @SerializedName("streamable")
    val streamable: String,
    @SerializedName("ontour")
    val ontour: String,
    @SerializedName("stats")
    val stats: Stats,
    @SerializedName("similar")
    val similar: Similar,
    @SerializedName("tags")
    val tags: Tags,
    @SerializedName("bio")
    val bio: Bio
)