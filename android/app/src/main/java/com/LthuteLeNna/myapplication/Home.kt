package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var player = MediaPlayer.create(this, R.raw.audio1_1)
        player.start();

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        val startButton = findViewById<Button>(R.id.startButton) as Button
        startButton.setOnClickListener{
            if (player.isPlaying()) player.stop()
            startActivity(Intent(this@Home, Menu::class.java ))
        }

        val instructionButton = findViewById<ImageButton>(R.id.infoIconHome)
        instructionButton.setOnClickListener {
            if (player.isPlaying()) player.stop()
            startActivity(Intent(this, homeInstruction::class.java))
        }
    }
}