package com.example.mybeeradviser

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = beerColor.selectedItem

            val beerList = getBeers(color.toString())

            val beers = beerList.joinToString("\n")
            val brands = findViewById<TextView>(R.id.brands)

            brands.text = beers
        }
    }
}

fun getBeers(color: String): List<String> {
    return when(color) {
        "light" -> listOf("Jail Pale Ale", "Lager Lite")
        "amber" -> listOf("Jack Amber", "Red Moose")
        "brown" -> listOf("Brown Bear Beer", "Bock Brownie")
        else -> listOf("Gout Stout", "Dark Daniel")
    }
}