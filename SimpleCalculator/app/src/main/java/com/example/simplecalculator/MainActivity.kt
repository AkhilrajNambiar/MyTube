package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculate.setOnClickListener {
            operate()
        }
    }

    private fun operate() {
        val firstNumstr = binding.firstNumberEditText.text.toString()
        val firstNum = firstNumstr.toDoubleOrNull()
        val secondNumstr = binding.secondNumberEditText.text.toString()
        val secondNum = secondNumstr.toDoubleOrNull()
        if(firstNum == null || secondNum == null){
            Toast.makeText(this, "One or both numbers are missing", Toast.LENGTH_SHORT).show()
            binding.output.text = ""
            return
        }
        val output = when(binding.operations.checkedRadioButtonId){
            R.id.add -> firstNum + secondNum
            R.id.subtract -> firstNum - secondNum
            R.id.multiplication -> firstNum * secondNum
            else -> firstNum / secondNum
        }
        binding.output.text = output.toString()
    }
}