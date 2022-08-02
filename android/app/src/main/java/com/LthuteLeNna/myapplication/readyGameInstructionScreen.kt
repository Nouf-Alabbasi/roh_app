package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class readyGameInstructionScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready_game_instruction_screen)

        // audio for game 3 from resource folder in drive
        var audio = resources.getIdentifier("instruction_ready", "raw", packageName)
        var mediaPlayer = MediaPlayer.create(this, audio)
        mediaPlayer.start()

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goBackButton = findViewById<ImageView>(R.id.backbutton_get_ready_game_instruction)
        goBackButton.setOnClickListener {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop()
            startActivity(Intent(this, GettingReadyGameHome::class.java))
        }
    }
}