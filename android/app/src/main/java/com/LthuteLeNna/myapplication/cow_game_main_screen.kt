package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class cow_game_main_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cow_game_main_screen)

        var player = MediaPlayer.create(this, R.raw.cow_0);
        player.start();

        //replay audio
        var repeat_inst = findViewById<ImageView>(R.id.imageView)
        repeat_inst.setOnClickListener {
            if (player.isPlaying()) {
                player.stop()
            }

            var player = MediaPlayer.create(this, R.raw.cow_0);
            player.start()
        }
        //replay audio

        try{
            supportActionBar?.hide()
        }catch(e: Exception){}

        var startButton = findViewById<Button>(R.id.cowGameStartButton) as Button
        startButton.setOnClickListener{
            if (player.isPlaying()) player.stop()
            startActivity(Intent(this@cow_game_main_screen, cow_game_numbers_screen::class.java))
        }

        var menuButton = findViewById<ImageButton>(R.id.goToCountingGameMain) as ImageButton
        menuButton.setOnClickListener{
            if (player.isPlaying()) player.stop()
            startActivity(Intent(this@cow_game_main_screen, Menu::class.java))
        }

        var infoButton = findViewById<ImageButton>(R.id.infoIconCowGame) as ImageButton
        infoButton.setOnClickListener{
            if (player.isPlaying()) player.stop()
            startActivity(Intent(this@cow_game_main_screen, cowGameInstruction::class.java))
        }



    }
}