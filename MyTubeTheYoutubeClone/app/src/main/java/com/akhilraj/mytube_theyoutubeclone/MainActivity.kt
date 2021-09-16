package com.akhilraj.mytube_theyoutubeclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_main)
        }
        catch (e:Exception) {
            Log.e("Videos error", e.stackTraceToString())
        }
    }
}