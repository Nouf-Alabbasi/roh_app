package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class ColorsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors_screen)

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToBontleGameMain5)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, GettingReadyGameHome::class.java))
        }

        var colors = arrayOf<String>("pink", "red", "yellow", "orange", "white", "blue", "grey", "green", "purple");

        var pinkAudio = resources.getIdentifier(colors[0], "raw", packageName);
        var mediaPlayer = MediaPlayer.create(this, pinkAudio);


        for (color in colors) {
            var id = resources.getIdentifier("color_${color}", "id", packageName)
            var colorCard = findViewById<ImageView>(id);
            colorCard.setOnClickListener {
                var colorAudio = resources.getIdentifier(color, "raw", packageName);
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(this, colorAudio);
                mediaPlayer.start()
            }
        }


        var goToGameButton = findViewById<ImageButton>(R.id.goToGame)
        goToGameButton.setOnClickListener {
            startActivity(Intent(this, ReadyGameLevel1::class.java))
        }
    }
}