package com.example.data.network.models


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("results")
    val results: Results
)