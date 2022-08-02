package com.LthuteLeNna.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class WordsGameLevelSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_game_level_select)

        try{
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToImagineGameMain)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, WordsMain::class.java))
        }

        var level1Card = findViewById<CardView>(R.id.level1Card)
        level1Card.setOnClickListener {
            startActivity(Intent(this, Words_Level_1_Categories::class.java))
        }

        var level2Card = findViewById<CardView>(R.id.level2Card)
        level2Card.setOnClickListener {
            startActivity(Intent(this, WordsLevel2Categories::class.java))
        }

        var level3Card = findViewById<CardView>(R.id.level3Card)
        level3Card.setOnClickListener {
            startActivity(Intent(this, WordLevel3Categories::class.java))
        }
    }
}