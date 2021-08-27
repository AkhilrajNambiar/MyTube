package com.example.moviebuff

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebuff.model.movieModel
import com.google.android.material.card.MaterialCardView

class MovieAdapter(private var context: Context, private var dataset: List<movieModel>, private val name: String): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    private var filteredMovies: MutableList<movieModel> = mutableListOf()
    init {
        for( movie in dataset ){
            val actorNames = movie.actors.map { context.resources.getString(it).toString() }
            if ( name in actorNames) {
                filteredMovies.add(movie)
            }
        }
    }


    class MovieHolder(view:View): RecyclerView.ViewHolder(view){
        var movieImage: ImageView = view.findViewById(R.id.moviePoster)
        var movieName: TextView = view.findViewById(R.id.movie_name)
        val movieCard: MaterialCardView = view.findViewById(R.id.movieDetailCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
//        Log.d("filteredMovies", filteredMovies.toString())
        val item = filteredMovies[position]
        holder.movieImage.setImageResource(item.moviePosters)
        holder.movieName.text = context.resources.getString(item.movies)
        holder.movieCard.setOnClickListener{
            val queryString: Uri = Uri.parse("${MoviesActivity.SEARCH_QUERY}+${holder.movieName.text.toString()}+${name}+movie".lowercase())
            val intent = Intent(Intent.ACTION_VIEW, queryString)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return filteredMovies.size
    }

}