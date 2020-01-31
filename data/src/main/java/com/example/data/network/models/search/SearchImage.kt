package com.example.data.network.models.search


import com.google.gson.annotations.SerializedName

data class SearchImage(
    @SerializedName("#text")
    val text: String,
    @SerializedName("size")
    val size: String
)