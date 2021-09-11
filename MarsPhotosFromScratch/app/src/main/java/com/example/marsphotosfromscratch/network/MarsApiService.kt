package com.example.marsphotosfromscratch.network

import com.example.marsphotosfromscratch.data.MarsPhoto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
//The converter tells Retrofit what to do with the data received from the web server
//Here we want the JSON response to be converted to a string

/*
* The moshi object that is responsible for converting the JSON string to Kotlin objects
* */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    //Get annotation with the endpoint value
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

object MarsApi {
    // To create this object only when we need it we can use lazy
//    val retrofitService: MarsApiService = retrofit.create(MarsApiService::class.java)
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}