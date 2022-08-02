package com.LthuteLeNna.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class Words_Level_1_Categories : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_level1_categories)

        try{
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToImagineGameMain3)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, WordsMain::class.java))
        }

        var intent = Intent(this, WordActivity::class.java)

        var characterCard = findViewById<CardView>(R.id.charactersCard)
        characterCard.setOnClickListener {
            intent.putExtra("wordSet", "level1Character")
            startActivity(intent)
        }

        var objectsCard = findViewById<CardView>(R.id.objectsCard)
        objectsCard.setOnClickListener {
            intent.putExtra("wordSet", "level1Objects")
            startActivity(intent)
        }
    }
}