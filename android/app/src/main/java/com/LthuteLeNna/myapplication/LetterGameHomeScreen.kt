package com.LthuteLeNna.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class LetterGameHomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter_game_home_screen)

        try{
            supportActionBar?.hide()
        }catch(e: Exception){}

        var menuButton = findViewById<ImageButton>(R.id.letterHuntHomeButton)
        menuButton.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

        var startActivityButton = findViewById<Button>(R.id.letterHuntStartButton)
        startActivityButton.setOnClickListener {
            startActivity(Intent(this, LetterHuntLettersScreen::class.java))
        }

        var infoButton = findViewById<ImageButton>(R.id.infoIconLetterGame)
        infoButton.setOnClickListener {
            startActivity(Intent(this, LetterGameInstructionScreen::class.java))
        }
    }
}