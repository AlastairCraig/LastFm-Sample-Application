package com.example.data.network.models.search


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("opensearch:Query")
    val opensearchQuery: OpensearchQuery,
    @SerializedName("opensearch:totalResults")
    val opensearchTotalResults: String,
    @SerializedName("opensearch:startIndex")
    val opensearchStartIndex: String,
    @SerializedName("opensearch:itemsPerPage")
    val opensearchItemsPerPage: String,
    @SerializedName("artistmatches")
    val artistmatches: Artistmatches,
    @SerializedName("@attr")
    val attr: Attr
)