package com.LthuteLeNna.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import java.lang.Exception

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        try{
            supportActionBar?.hide()
        } catch(e: Exception) {}

        // get the cow game button and go to the cow game main screen
        val cowGameButton = findViewById<CardView>(R.id.cowGameCard) as CardView
        cowGameButton.setOnClickListener{
            startActivity(Intent(this@Menu, cow_game_main_screen::class.java))
        }

        val letterGameButton = findViewById<CardView>(R.id.letterHuntCard)
        letterGameButton.setOnClickListener {
            startActivity(Intent(this, LetterGameHomeScreen::class.java))
        }

        val gettingReadyGame = findViewById<CardView>(R.id.getReadyCard) as CardView
        gettingReadyGame.setOnClickListener {
            startActivity(Intent(this, GettingReadyGameHome::class.java))
        }

        var wordsGame = findViewById<CardView>(R.id.wordsGameCard)
        wordsGame.setOnClickListener {
            startActivity(Intent(this, WordsMain::class.java))
        }
    }
}