package com.akhilraj.mytube_theyoutubeclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akhilraj.mytube_theyoutubeclone.databinding.FragmentHomeBinding
import com.akhilraj.mytube_theyoutubeclone.models.VideosViewModel

class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? = null
    val binding get() = _binding!!
    private val viewModel: VideosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
