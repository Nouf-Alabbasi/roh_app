package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class imagineTimeInstructionScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagine_time_instruction_screen)


        //problem -> the audio file doesn't work
                // I can add two multiplayers, and I can only do that using previously added audio files
        var audio_2 = resources.getIdentifier("c", "raw", packageName)
        var mediaPlayer_2 = MediaPlayer.create(this, audio_2)
        mediaPlayer_2.start()


        // audio for game 4 from resource folder in drive
        var audio = resources.getIdentifier("instruction_imagine", "raw", packageName)
        var mediaPlayer = MediaPlayer.create(this, audio)
        mediaPlayer.start()

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goBackButton = findViewById<ImageView>(R.id.backbutton_Imagine_game_instruction)
        goBackButton.setOnClickListener {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop()
            startActivity(Intent(this, WordsMain::class.java))
        }
    }
}