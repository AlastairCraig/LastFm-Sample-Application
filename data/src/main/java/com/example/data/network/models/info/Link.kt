package com.example.data.network.models.info


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("#text")
    val text: String,
    @SerializedName("rel")
    val rel: String,
    @SerializedName("href")
    val href: String
)