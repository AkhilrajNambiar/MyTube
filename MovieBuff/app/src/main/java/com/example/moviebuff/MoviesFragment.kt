package com.example.moviebuff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebuff.data.MovieSource
import com.example.moviebuff.databinding.FragmentMoviesBinding
import com.example.moviebuff.model.movieModel


class MoviesFragment : Fragment() {

    companion object{
        const val NAME = "actorName"
        const val SEARCH_QUERY = "https://www.google.com/search?q="
    }
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var actorName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            actorName = it.getString("actorName").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerViewMovie
        val dataset: List<movieModel> = MovieSource().movieList()
        recyclerView.adapter = MovieAdapter(requireContext(), dataset, actorName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}