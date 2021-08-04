package com.example.slogans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.slogans.data.Datasource
import com.example.slogans.model.Slogans


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mySlogans: List<Slogans> = Datasource().loadSlogans()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, mySlogans)
        recyclerView.setHasFixedSize(true)
    }
}