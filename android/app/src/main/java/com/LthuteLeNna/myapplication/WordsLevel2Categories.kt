package com.LthuteLeNna.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class WordsLevel2Categories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_level2_categories)

        try {
            supportActionBar?.hide()
        } catch(e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToImagineGameMain2)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, WordsMain::class.java))
        }

        // placesCard activitiesCard
        var placesCard = findViewById<CardView>(R.id.placesCard)
        var activitiesCard = findViewById<CardView>(R.id.activitiesCard)

        var intent = Intent(this, WordActivity::class.java)

        placesCard.setOnClickListener {
            intent.putExtra("wordSet", "level2Places")
            startActivity(intent)
        }

        activitiesCard.setOnClickListener {
            intent.putExtra("wordSet", "level2Activities")
            startActivity(intent)
        }
    }
}