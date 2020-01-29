package com.example.data.network.models.info


import com.google.gson.annotations.SerializedName

data class Similar(
    @SerializedName("artist")
    val artists: List<SimilarArtist>
)