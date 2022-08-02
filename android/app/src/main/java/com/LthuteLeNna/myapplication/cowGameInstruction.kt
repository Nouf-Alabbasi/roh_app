package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class cowGameInstruction : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cow_game_instruction)

        // audio for game 2 from resource folder in drive
        var audio = resources.getIdentifier("instruction_cow", "raw", packageName)
        var mediaPlayer = MediaPlayer.create(this, audio)
        mediaPlayer.start()

        try {
            supportActionBar?.hide()
        } catch(e: Exception){}

        var goBackButton = findViewById<ImageButton>(R.id.backbutton_cow_game_instruction)
        goBackButton.setOnClickListener {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop()
            startActivity(Intent(this, cow_game_main_screen::class.java))
        }
    }
}