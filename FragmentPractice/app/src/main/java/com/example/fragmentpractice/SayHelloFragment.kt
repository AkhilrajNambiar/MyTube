package com.example.fragmentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragmentpractice.databinding.FragmentNameBinding
import com.example.fragmentpractice.databinding.FragmentSayHelloBinding

class SayHelloFragment : Fragment() {
    private var _binding: FragmentSayHelloBinding? = null
    private val binding get() = _binding!!
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let{
            name = it.getString("name").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSayHelloBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView: TextView = view.findViewById(R.id.helloEverybody)
        textView.text = "Hello ${name}, so glad that you are following this!"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}