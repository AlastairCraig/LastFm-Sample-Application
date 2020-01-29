package com.example.data.network.models.info


import com.google.gson.annotations.SerializedName

data class Bio(
    @SerializedName("links")
    val links: Links,
    @SerializedName("published")
    val published: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("content")
    val content: String
)