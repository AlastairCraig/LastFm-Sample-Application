package com.example.data.network.models


import com.google.gson.annotations.SerializedName

data class Artistmatches(
    @SerializedName("artist")
    val artist: List<Artist>
)