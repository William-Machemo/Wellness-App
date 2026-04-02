package com.william.chui_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
//        Healthy recipe intent
//        finding the views from the layout using their ids

//        create a variable to store the buttons

        val recipe=findViewById<Button>(R.id.recipes)

//        set onclick listener
        recipe.setOnClickListener {
//            write your intents
            val recipeIntnent= Intent(applicationContext, HealthyRecipe::class.java)
            startActivity(recipeIntnent)

        }
//        nutrition intent
//        create a variable
        val nutrition=findViewById<Button>(R.id.nutrition)

//        set onclick
        nutrition.setOnClickListener {
//            write your intent
            val nutrition= Intent(applicationContext, NutritionAdvice::class.java)

            startActivity(nutrition)
        }

//        meditation intent

        val meditation=findViewById<Button>(R.id.meditation)
//        setonclick
        meditation.setOnClickListener {

            val meditation= Intent(applicationContext,Meditation::class.java)

            startActivity(meditation)
        }
//
    }
}