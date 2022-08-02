package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import java.lang.Exception

class ShapesScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shapes_screen)

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var shapes = arrayOf<String>("square", "circle", "diamond", "oval", "triangle", "star", "heart", "rectangle", "moon");

        var mediaPlayer = MediaPlayer.create(this, R.raw.square)

        for (i in shapes) {
            var rId = resources.getIdentifier(i, "id", packageName);
            var view = findViewById<ImageView>(rId);
            view.setOnClickListener {
                try {
                    var audio = resources.getIdentifier(i, "raw", packageName);


                    if (mediaPlayer.isPlaying()){
                        mediaPlayer.stop()
                    };
                    mediaPlayer = MediaPlayer.create(this, audio);
                    mediaPlayer.start();
                } catch (e: Exception) {}
            }
        }

        var goToGameMain = findViewById<ImageButton>(R.id.goToBontleGameMain4)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, GettingReadyGameHome::class.java))
        }

        var goToGameButton = findViewById<ImageButton>(R.id.goToGame)
        goToGameButton.setOnClickListener {
            startActivity(Intent(this, ReadyGameLevel2::class.java))
        }
    }
}