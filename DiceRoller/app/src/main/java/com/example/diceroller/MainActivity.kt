package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //finding the button by it's ID
        //Every view has an ID denoted by R.id.<view_name>
        //Every string has an ID denoted by R.string.<val>
        val rollButton: Button = findViewById(R.id.button)
        //Adding a click event for our button
        rollButton.setOnClickListener {
            //Showing a text message when the button is clicked
            //Toast.makeText(this,"Dice rolled",Toast.LENGTH_SHORT).show()
            //We will work with updating the textview when the button is clicked
            rollDice()
        }
        //To show a random Dice  Image in when the app is started
        rollDice()
    }

    private fun rollDice() {
        //Creating a six sided dice
        val dice = Dice(6)
        val rollTo = dice.roll()
        //Selecting the imageView
        val diceImage: ImageView = findViewById(R.id.imageView)
        //Setting a variable to a random drawable resource
        val drawResource = when(rollTo){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Drawing the random dice resource
        diceImage.setImageResource(drawResource)
        //Setting the content description for the dice
        diceImage.contentDescription = rollTo.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
