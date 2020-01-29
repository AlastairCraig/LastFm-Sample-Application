package com.example.data.network.models.info


import com.google.gson.annotations.SerializedName

data class InfoResponse(
    @SerializedName("artist")
    val artistInfo: ArtistInfo
)