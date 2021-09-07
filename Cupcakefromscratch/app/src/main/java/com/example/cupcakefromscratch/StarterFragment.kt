package com.example.cupcakefromscratch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.cupcakefromscratch.databinding.FragmentStarterBinding
import com.example.cupcakefromscratch.model.SharedViewModel

class StarterFragment : Fragment() {
    private var _binding: FragmentStarterBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStarterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val oneCupcake = binding.oneCupcake
        val sixCupcakes = binding.sixCupcakes
        val twelveCupcakes = binding.twelveCupcakes
        oneCupcake.setOnClickListener {
            orderCupcake(1)
        }
        sixCupcakes.setOnClickListener {
            orderCupcake(6)
        }
        twelveCupcakes.setOnClickListener {
            orderCupcake(12)
        }
    }

    private fun orderCupcake(quantity:Int){
        sharedViewModel.setQuantity(quantity)
        if(sharedViewModel.hasNoFlavor()){
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }
        val action = StarterFragmentDirections.actionStarterFragmentToFlavorFragment()
        view?.findNavController()?.navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}