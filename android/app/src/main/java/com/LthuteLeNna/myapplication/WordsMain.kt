package com.LthuteLeNna.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class WordsMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_main)

        try {
            supportActionBar?.hide()
        } catch(e: Exception) {}

        var menuButton = findViewById<ImageButton>(R.id.goToCountingGameMain)
        menuButton.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

        var startButton = findViewById<Button>(R.id.wordsGameStartButton)
        startButton.setOnClickListener {
            startActivity(Intent(this, WordsGameLevelSelect::class.java))
        }

        val instructionButton = findViewById<ImageButton>(R.id.infoIconImagine)
        instructionButton.setOnClickListener {
//            if (player.isPlaying()) player.stop()
            startActivity(Intent(this, imagineTimeInstructionScreen::class.java))
        }
    }
}