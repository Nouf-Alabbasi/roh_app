package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import java.lang.Exception

class GettingReadyGameHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getting_ready_game_home)

        var audio = resources.getIdentifier("help_get_ready", "raw", packageName)
        var mediaPlayer = MediaPlayer.create(this, audio)
        mediaPlayer.start()

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var menuButton = findViewById<ImageButton>(R.id.goToCountingGameMain)
        menuButton.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop()
            }
        }

        var infoButton = findViewById<ImageButton>(R.id.infoIconGetReadyGame) as ImageButton
        infoButton.setOnClickListener{
            if (mediaPlayer.isPlaying()) mediaPlayer.stop()
            startActivity(Intent(this, readyGameInstructionScreen::class.java))
        }

        var startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            startActivity(Intent(this, ReadyGameLevelSelection::class.java))
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop()
            }
        }




    }
}