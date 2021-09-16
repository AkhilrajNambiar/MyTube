package com.akhilraj.mytube_theyoutubeclone.API

import com.akhilraj.mytube_theyoutubeclone.data.VideosList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val URL = "https://www.googleapis.com/youtube/v3"
private const val API_KEY = "AIzaSyBWnlXfHtN__Yp9fg82ntmPmaPPr6RLU_g"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .baseUrl(URL)
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

interface GetVideos {
    @GET("/videos?chart=mostPopular&maxResults=5&key=${API_KEY}")
    suspend fun getMostPopularVideosList(): String
}

object VideosApi {
    val retrofitService: GetVideos by lazy{
        retrofit.create(GetVideos::class.java)
    }
}