package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class WordsMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_main)

        try {
            supportActionBar?.hide()
        } catch(e: Exception) {}

        // add audio
        var audio = resources.getIdentifier("imaginetimeinst", "raw", packageName)
        var mediaPlayer = MediaPlayer.create(this, audio)
        mediaPlayer.start()

        val instructionButton = findViewById<ImageButton>(R.id.infoIconImagine)
        instructionButton.setOnClickListener {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop()
            startActivity(Intent(this, imagineTimeInstructionScreen::class.java))
        }

        var menuButton = findViewById<ImageButton>(R.id.goToCountingGameMain)
        menuButton.setOnClickListener {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop()
            startActivity(Intent(this, Menu::class.java))
        }

        var startButton = findViewById<Button>(R.id.wordsGameStartButton)
        startButton.setOnClickListener {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop()
            startActivity(Intent(this, WordsGameLevelSelect::class.java))
        }

        //replay audio
        var repeat_inst = findViewById<ImageView>(R.id.homeScreenGirl)
        repeat_inst.setOnClickListener {
//            if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop()
//            }
            var audio = resources.getIdentifier("imaginetimeinst", "raw", packageName)
            var mediaPlayer = MediaPlayer.create(this, audio)
            mediaPlayer.start()
        }
        //replay audio

    }
}