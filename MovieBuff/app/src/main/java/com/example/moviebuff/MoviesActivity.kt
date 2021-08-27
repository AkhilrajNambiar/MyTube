package com.example.moviebuff

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebuff.data.MovieSource
import com.example.moviebuff.databinding.ActivityMoviesBinding

class MoviesActivity: AppCompatActivity() {
    companion object{
        const val NAME = "actorName"
        const val SEARCH_QUERY = "https://www.google.com/search?q="
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        val dataset = MovieSource().movieList()
        val actorName = intent?.extras?.getString(NAME).toString()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_movie)
        recyclerView.adapter = MovieAdapter(this, dataset, actorName)
    }
}