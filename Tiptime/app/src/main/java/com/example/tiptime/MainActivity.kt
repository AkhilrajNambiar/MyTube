package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat



class MainActivity: AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateTip.setOnClickListener {
            calculateTip()
        }
    }
    private fun calculateTip(){
        val costString = binding.costOfServiceEditText.text.toString()
        val cost = costString.toDoubleOrNull()
        if(cost == null){
            Toast.makeText(this, "Please enter a service cost!", Toast.LENGTH_SHORT).show()
            binding.tipResult.text = ""
            return
        }
        val tipPercentage = when(binding.tipOptions.checkedRadioButtonId){
            R.id.tip_20_percent -> 0.2
            R.id.tip_18_percent -> 0.18
            else -> 0.15
        }
        var tip = cost * tipPercentage
        // If the user wants to round up the tip
        // Check if the switch option is selected
        val roundUp = binding.roundUpSwitch.isChecked
        if(roundUp){
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_result, formattedTip)
    }
}