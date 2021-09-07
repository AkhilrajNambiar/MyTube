package com.example.cupcakefromscratch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.cupcakefromscratch.databinding.FragmentPickupBinding
import com.example.cupcakefromscratch.model.SharedViewModel

class PickupFragment : Fragment() {
    private var _binding: FragmentPickupBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPickupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        val cancel = binding.cancelButton
        cancel.setOnClickListener {
            sharedViewModel.resetOrder()
            val action = PickupFragmentDirections.actionPickupFragmentToStarterFragment()
            view.findNavController().navigate(action)
        }
        val next = binding.nextButton
        next.setOnClickListener {
            val action = PickupFragmentDirections.actionPickupFragmentToSummaryFragment()
            view.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}