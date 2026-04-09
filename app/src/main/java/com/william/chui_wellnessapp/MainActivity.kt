package com.william.chui_wellnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {

//    a variable to store all the ads once it loads

    private var mInterstitialAd: InterstitialAd?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // ---------------- ADS ----------------
        MobileAds.initialize(this)

        val adView = findViewById<AdView>(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)


//        loads interstitial ad
        loadInterstitialAd()

        // ---------------- WINDOW INSETS ----------------
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // ---------------- BUTTONS ----------------

        val recipeBtn = findViewById<Button>(R.id.recipes)
        val nutritionBtn = findViewById<Button>(R.id.nutrition)
        val meditationBtn = findViewById<Button>(R.id.meditation)
        val exerciseBtn = findViewById<Button>(R.id.exercise)
        val hydrationBtn = findViewById<Button>(R.id.hydration)
        val motivationBtn = findViewById<Button>(R.id.motivation)
        val goalsBtn = findViewById<Button>(R.id.goals)
        val progressBtn = findViewById<Button>(R.id.progress)

        // ---------------- CLICK LISTENERS ----------------

        recipeBtn.setOnClickListener {
            startActivity(Intent(this, HealthyRecipe::class.java))

//            display the ad
            showInterstitialAd()
        }

        nutritionBtn.setOnClickListener {
            startActivity(Intent(this, NutritionAdvice::class.java))
        }

        meditationBtn.setOnClickListener {
            startActivity(Intent(this, Meditation::class.java))

              showInterstitialAd()
        }

        exerciseBtn.setOnClickListener {
            startActivity(Intent(this, StartExercise::class.java))
        }

        hydrationBtn.setOnClickListener {
            startActivity(Intent(this, HydrationAlert::class.java))
        }

        motivationBtn.setOnClickListener {
            startActivity(Intent(this, DailyMotivation::class.java))
        }

        goalsBtn.setOnClickListener {
            startActivity(Intent(this, WeeklyGoals::class.java))
        }

        progressBtn.setOnClickListener {
            startActivity(Intent(this, CheckProgress::class.java))
        }
    }


    fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712", // Test ID
            adRequest,
            object : InterstitialAdLoadCallback() {

                override fun onAdLoaded(ad: InterstitialAd) {
                    mInterstitialAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    mInterstitialAd = null
                }
            }
        )
    }
    //Show Interstitial ad
    fun showInterstitialAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
        }
    }
}
