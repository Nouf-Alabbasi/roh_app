package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import java.lang.Exception

class LetterGameInstructionScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter_game_instruction_screen)

        // audio for game 1 from resource folder in drive
        var audio = resources.getIdentifier("instruction_letter", "raw", packageName)
        var mediaPlayer = MediaPlayer.create(this, audio)
        mediaPlayer.start()

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goBackButton = findViewById<ImageView>(R.id.backbutton_letter_game_instruction)
        goBackButton.setOnClickListener {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop()
            startActivity(Intent(this, LetterGameHomeScreen::class.java))
        }
    }
}