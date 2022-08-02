package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import java.lang.Exception

class cow_game_numbers_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cow_game_numbers_screen)

        try {
            supportActionBar?.hide()
        } catch(e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToCountingGameMain) as ImageButton
        goToGameMain.setOnClickListener{
            startActivity(Intent(this, cow_game_main_screen::class.java))
        }

        var numbers: MutableList<ImageView> = mutableListOf();

        for (i in 1..10){
            var viewId = resources.getIdentifier("num${i}", "id", packageName);
            var numberView = findViewById<ImageView>(viewId)
            numbers.add(numberView);
        }

        var numAudio: MutableList<MediaPlayer> = mutableListOf();

        for (i in 1..10) {
            var audio = resources.getIdentifier("num${i}", "raw", packageName)
            var numPlayer = MediaPlayer.create(this, audio);
            numAudio.add(numPlayer);
        }

        for (i in 0..9) {
            numbers[i].setOnClickListener {
                for (j in numAudio) {
                    if (j.isPlaying()) {
                        j.stop()
                    }
                }
                numAudio[i].start();
            }
        }



        var goToGameButton = findViewById<ImageButton>(R.id.practiceIcon) as ImageButton
        goToGameButton.setOnClickListener{
            startActivity(Intent(this@cow_game_numbers_screen, cow_game_level_select::class.java))
        }
    }
}