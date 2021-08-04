package com.example.dragonballz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val change: Button = findViewById(R.id.button)


        change.setOnClickListener {
            //Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
            val naya = Old()
            mapNumberToDBZ(naya.randomNum())
        }
        val randomGeneration = Old()
        mapNumberToDBZ(randomGeneration.randomNum())
    }
    private fun mapNumberToDBZ(mappingNumber:Int){
        val name: TextView = findViewById(R.id.textView)
        val description: TextView = findViewById(R.id.textView2)
        val character: ImageView = findViewById(R.id.imageView)
        when(mappingNumber){
            1 -> {
                name.text = getString(R.string.goku)
                description.text = getString(R.string.goku_des)
                character.setImageResource(R.drawable.goku)
            }
            2 -> {
                name.text = getString(R.string.vegeta)
                description.text = getString(R.string.vegeta_des)
                character.setImageResource(R.drawable.vegeta)
            }
            3 -> {
                name.text = getString(R.string.gohan)
                description.text = getString(R.string.gohan_des)
                character.setImageResource(R.drawable.gohan)
            }
            4 -> {
                name.text = getString(R.string.trunks)
                description.text = getString(R.string.trunks_des)
                character.setImageResource(R.drawable.trunks)
            }
            5 -> {
                name.text = getString(R.string.piccolo)
                description.text = getString(R.string.piccolo_des)
                character.setImageResource(R.drawable.piccolo)
            }
            6 -> {
                name.text = getString(R.string.beerus)
                description.text = getString(R.string.beerus_des)
                character.setImageResource(R.drawable.beerus)
            }
            7 -> {
                name.text = getString(R.string.jiren)
                description.text = getString(R.string.jiren_des)
                character.setImageResource(R.drawable.jiren)
            }
            8 -> {
                name.text = getString(R.string.gogeta)
                description.text = getString(R.string.gogeta_des)
                character.setImageResource(R.drawable.gogeta)
            }
            9 -> {
                name.text = getString(R.string.broly)
                description.text = getString(R.string.broly_des)
                character.setImageResource(R.drawable.broly)
            }
        }
    }
}
class Old{
    fun randomNum():Int{
        return (1..9).random()
    }
}
