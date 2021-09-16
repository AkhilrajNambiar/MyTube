package com.akhilraj.mytube_theyoutubeclone.data

import com.squareup.moshi.Json

data class VideosList(
    val kind: String,
    @Json(name = "etag")val eTag: String,
    val items:List<AboutVideoinShort>,
    val nextPageToken: String,
    val pageInfo: PageInformation
)

data class AboutVideoinShort(
    val kind: String,
    @Json(name = "etag")val eTag: String,
    val id: String
)

data class PageInformation(
    val totalPageResults: Int,
    val resultsPerPage: Int
)