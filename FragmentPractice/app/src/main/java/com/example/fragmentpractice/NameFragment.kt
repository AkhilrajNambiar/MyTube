package com.example.fragmentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fragmentpractice.databinding.FragmentNameBinding

class NameFragment : Fragment() {
    private var _binding:FragmentNameBinding? = null
    private val binding get() = _binding!!
    lateinit var name: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nameView = view.findViewById<EditText>(R.id.nameEdit)
        val sayHelloButton: Button = view.findViewById(R.id.say_hello)
        sayHelloButton.setOnClickListener{
            name = nameView.text.toString()
            val action = NameFragmentDirections.actionNameFragmentToSayHelloFragment(name = name)
            view.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}