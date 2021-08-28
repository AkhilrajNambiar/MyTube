package com.example.moviebuff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebuff.data.Actorsource
import com.example.moviebuff.data.MovieSource
import com.example.moviebuff.databinding.FragmentActorBinding

class ActorFragment : Fragment() {
    private var _binding: FragmentActorBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dataset = Actorsource().actorsList()
        recyclerView = binding.recyclerView
        recyclerView.adapter = NameAdapter(requireContext(), dataset)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}