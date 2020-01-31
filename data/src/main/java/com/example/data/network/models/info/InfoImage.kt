package com.example.data.network.models.info


import com.google.gson.annotations.SerializedName

data class InfoImage(
    @SerializedName("#text")
    val text: String,
    @SerializedName("size")
    val size: String
)