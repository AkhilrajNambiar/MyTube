package com.example.cupcakefromscratch.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

private const val PRICE_PER_CUPCAKE = 2.0
private const val SAME_DAY_DELIVERY_PRICE = 3.0

class SharedViewModel: ViewModel(){

    private val _quantity = MutableLiveData<Int>(0)
    val quantity:LiveData<Int> = _quantity

    private val _flavor = MutableLiveData<String>()
    val flavor:LiveData<String> = _flavor

    private val _date = MutableLiveData<String>()
    val date:LiveData<String> = _date

    private val _price = MutableLiveData<Double>()
    val price:LiveData<String> = Transformations.map(_price){
        NumberFormat.getCurrencyInstance().format(it)
    }

    val dateOptions = pickupOptions()

    init {
        resetOrder()
    }

    fun setQuantity(numberOfCupcakes: Int){
        _quantity.value = numberOfCupcakes
        updatePrice()
    }

    fun setFlavor(desiredflavor: String){
        _flavor.value = desiredflavor
    }

    fun setDate(pickupDate: String){
        _date.value = pickupDate
        updatePrice()
    }

    fun hasNoFlavor():Boolean{
        return _flavor.value.isNullOrEmpty()
    }

    private fun pickupOptions(): List<String>{
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4){
            // First add the date formatted as we need into the options list
            options.add(formatter.format(calendar.time))
            // Then increment the date by 1
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }
    fun resetOrder(){
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dateOptions[0]
        _price.value = 0.0
    }

    private fun updatePrice(){
        var cost = quantity.value?.times(PRICE_PER_CUPCAKE)
        if(_date.value == dateOptions[0]){
            cost = cost?.plus(SAME_DAY_DELIVERY_PRICE)
        }
        _price.value = cost
    }
}