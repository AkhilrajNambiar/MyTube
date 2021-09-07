package com.example.cupcakefromscratch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.cupcakefromscratch.databinding.FragmentSummaryBinding
import com.example.cupcakefromscratch.model.SharedViewModel

class SummaryFragment : Fragment() {
    private var _binding: FragmentSummaryBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        val cancel = binding.cancelOrder
        cancel.setOnClickListener {
            sharedViewModel.resetOrder()
            val action = SummaryFragmentDirections.actionSummaryFragmentToStarterFragment()
            view.findNavController().navigate(action)
        }
        //IF the quantity is null then 0 will be sent to the variable numberOfCupcakes
        val numberOfCupcakes = sharedViewModel.quantity.value ?: 0
        val sendOrder = binding.sendOrder
        sendOrder.setOnClickListener {
            val orderDetails = """
                Quantity: ${resources.getQuantityString(R.plurals.cupcakes, numberOfCupcakes, numberOfCupcakes)}
                Flavor: ${sharedViewModel.flavor.value}
                Pickup date: ${sharedViewModel.date.value}
                Total: ${sharedViewModel.price.value}
                
                Thank You!
            """.trimIndent()
            // Create an ACTION_SEND implicit intent with order details in the intent extras
            val intent = Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_SUBJECT, "New order")
                .putExtra(Intent.EXTRA_TEXT, orderDetails)

            // Check if there's an app that can handle this intent before launching it
            if (activity?.packageManager?.resolveActivity(intent,0) != null) {
                // Start a new activity with the given intent (this may open the share dialog on a
                // device if multiple apps can handle this intent)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}