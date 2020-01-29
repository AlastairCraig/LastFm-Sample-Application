package com.example.data.network.models.info


import com.google.gson.annotations.SerializedName

data class Tags(
    @SerializedName("tag")
    val tag: List<Tag>
)