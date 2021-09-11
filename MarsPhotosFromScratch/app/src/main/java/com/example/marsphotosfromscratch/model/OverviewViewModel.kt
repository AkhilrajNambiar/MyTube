package com.example.marsphotosfromscratch.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotosfromscratch.R
import com.example.marsphotosfromscratch.data.MarsPhoto
import com.example.marsphotosfromscratch.network.MarsApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class MarsApiStatus {LOADING, SUCCESS, FAILURE}

class OverviewViewModel: ViewModel() {

    private var _status = MutableLiveData<MarsApiStatus>()
    val status: LiveData<MarsApiStatus> = _status

    private var _photos = MutableLiveData<List<MarsPhoto>>()
    val photos: LiveData<List<MarsPhoto>> = _photos

    init{
        getMarsPhotos()
    }

    private fun getMarsPhotos(){
        //When the api is loading the status is set using MarsApiStatus.LOADING
        _status.value = MarsApiStatus.LOADING
        //Launching a coroutine to asynchronously fetch the photos
        viewModelScope.launch {
            try{
                //Set the photos value to the data obtained from the retrofit object MarsApi.retrofitService
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = MarsApiStatus.SUCCESS
            }
            catch (e:Exception) {
                _status.value = MarsApiStatus.FAILURE
                _photos.value = listOf()
            }
        }
    }
}