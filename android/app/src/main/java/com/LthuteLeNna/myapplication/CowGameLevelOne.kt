package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView
import java.lang.Exception
import java.util.*
import kotlin.concurrent.schedule
import kotlin.random.Random

class CowGameLevelOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cow_game_level_one)

        try {
            supportActionBar?.hide()
        } catch(e: Exception){}

        var confetti = findViewById<GifImageView>(R.id.cowGameConfetti) as GifImageView
        var instructionText = findViewById<TextView>(R.id.instructionText) as TextView
        var numCowsToFind: Int = 0
        var wonText = findViewById<TextView>(R.id.wonText) as TextView
        var babyCowPositions: MutableList<ImageView> = mutableListOf<ImageView>()
        var babyCowFoundPositions: MutableList<ImageView> = mutableListOf<ImageView>()

        var goToGameMain = findViewById<ImageButton>(R.id.goToCountingGameMain) as ImageButton
        goToGameMain.setOnClickListener{
            startActivity(Intent(this, cow_game_main_screen::class.java))
        }

        var practiceIcon = findViewById<ImageButton>(R.id.practiceIcon)
        practiceIcon.setOnClickListener {
            startActivity(Intent(this, cow_game_numbers_screen::class.java))
        }

        fun StartGame() {
            confetti.visibility = View.INVISIBLE
            numCowsToFind = Random.nextInt(1,10)
            instructionText.text = "Help Mama Cow find " + numCowsToFind + " of her babies"
            wonText.text = numCowsToFind.toString()
            wonText.visibility = View.INVISIBLE

            var audio = resources.getIdentifier("find${numCowsToFind}", "raw", packageName);
            var mediaPlayer_start = MediaPlayer.create(this, audio)

            mediaPlayer_start.start();

            //replay audio
            var repeat_inst = findViewById<ImageView>(R.id.MamaCow)
            repeat_inst.setOnClickListener {
                if (mediaPlayer_start.isPlaying()) {
                    mediaPlayer_start.stop()
                }

                var audio = resources.getIdentifier("find${numCowsToFind}", "raw", packageName);
                var mediaPlayer_start = MediaPlayer.create(this, audio)
                mediaPlayer_start.start()
            }
            //replay audio

            babyCowPositions.clear()
            babyCowFoundPositions.clear()

            // get all playable positions
            for (i in 1..12){
                var viewId: String = "babyCowPos"+i.toString()
                var resId = resources.getIdentifier(viewId,"id", packageName);
                var cowPosition = findViewById<ImageView>(resId) as ImageView
                babyCowPositions.add(cowPosition)
            }

            // get all found cowPositions
            for (i in 1..10){
                var viewId: String = "foundCowPos"+ i.toString()
                var resId = resources.getIdentifier(viewId,"id", packageName)
                var foundCowPosition = findViewById<ImageView>(resId) as ImageView
                foundCowPosition.visibility = View.INVISIBLE
                babyCowFoundPositions.add(foundCowPosition)
            }

            babyCowPositions.shuffle();

            for (i in numCowsToFind..12-1){
                babyCowPositions[i].setImageDrawable(null);
            }

            var cnt = 0;
            for (i in 0..numCowsToFind){
                babyCowPositions[i].setOnClickListener {
                    cnt++;
                    babyCowFoundPositions[cnt-1].visibility = View.VISIBLE
                    babyCowPositions[i].setImageDrawable(null)
                    if (cnt == numCowsToFind) {
                        confetti.visibility = View.VISIBLE
                        wonText.visibility = View.VISIBLE

                        var foundAudio = resources.getIdentifier("num${numCowsToFind}", "raw", packageName);
                        var mediaPlayer_found = MediaPlayer.create(this, foundAudio)
                        if (mediaPlayer_start.isPlaying()) mediaPlayer_start.stop()
                        mediaPlayer_found.start()

                        // StartGame()
                        var timer = Timer("schedule", true)
                        timer.schedule(5000){
                            val intent: Intent = intent
                            finish()
                            startActivity(intent)
                        }
                    }
                }
            }


        }

        StartGame()

    }
}