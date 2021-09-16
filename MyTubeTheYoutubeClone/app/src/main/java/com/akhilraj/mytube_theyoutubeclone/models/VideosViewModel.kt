package com.akhilraj.mytube_theyoutubeclone.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akhilraj.mytube_theyoutubeclone.API.VideosApi
import com.akhilraj.mytube_theyoutubeclone.data.VideosList
import kotlinx.coroutines.*
import java.lang.Exception

class VideosViewModel: ViewModel() {
    private var _allVideos = MutableLiveData<String>()
    val allVideos:LiveData<String> = _allVideos

    private val job = Job()

    init {
        try {
            getVideos()
        }
        catch (e:Exception) {
            Log.e("Videos error", e.stackTraceToString())
        }
    }

    private fun getVideos() {
        viewModelScope.launch {
            try {
                _allVideos.value = VideosApi.retrofitService.getMostPopularVideosList()
                Log.d("Videos", "The values are set")
            }
            catch (e:Exception) {
                Log.e("Videos", e.stackTraceToString())
            }
        }
    }

}