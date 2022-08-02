package com.LthuteLeNna.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class WordLevel3Categories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_level3_categories)

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToImagineGameMain3)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, WordsMain::class.java))
        }

        var charactersCard = findViewById<CardView>(R.id.charactersCard)
        var placesCard = findViewById<CardView>(R.id.placesCard)
        var objectsCard = findViewById<CardView>(R.id.objectsCard)
        var activitiesCard = findViewById<CardView>(R.id.activitiesCard)

        var intent = Intent(this, WordActivity::class.java)

        charactersCard.setOnClickListener {
            intent.putExtra("wordSet", "level3Characters")
            startActivity(intent)
        }

        placesCard.setOnClickListener {
            intent.putExtra("wordSet", "level3Places")
            startActivity(intent)
        }

        objectsCard.setOnClickListener {
            intent.putExtra("wordSet", "level3Objects")
            startActivity(intent)
        }

        activitiesCard.setOnClickListener {
            intent.putExtra("wordSet", "level3Activities")
            startActivity(intent)
        }

    }
}