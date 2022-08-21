package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

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

        //audio obtained from the drive 1.Instructions.m4a
        var audio = resources.getIdentifier("letterhuntinst", "raw", packageName)
        var mediaPlayer = MediaPlayer.create(this, audio);
        mediaPlayer.start()

        //replay audio
        var repeat_inst = findViewById<ImageView>(R.id.imageView10)
        repeat_inst.setOnClickListener {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop()
            }
            var audio = resources.getIdentifier("letterhuntinst", "raw", packageName)
            var mediaPlayer = MediaPlayer.create(this, audio);
            mediaPlayer.start()
        }
        //replay audio
    }
}