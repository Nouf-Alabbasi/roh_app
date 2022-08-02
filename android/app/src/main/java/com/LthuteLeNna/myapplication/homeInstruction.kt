package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class homeInstruction : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_instruction)


        var audio = resources.getIdentifier("instruction_homepage", "raw", packageName)
        var mediaPlayer = MediaPlayer.create(this, audio)
        mediaPlayer.start()

        try {
            supportActionBar?.hide()
        } catch (e: Exception){}

        var goToHomeButton = findViewById<ImageButton>(R.id.backbutton_home_instruction)
        goToHomeButton.setOnClickListener {
            if (mediaPlayer.isPlaying()) mediaPlayer.stop()
            startActivity(Intent(this, Home::class.java))
        }
    }
}