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

class ReadyGameLevel1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready_game_level1)

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToBontleGameMain)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, GettingReadyGameHome::class.java))
        }

        var practiceIcon = findViewById<ImageButton>(R.id.practiceIcon)
        practiceIcon.setOnClickListener {
            startActivity(Intent(this, ColorsScreen::class.java))
        }

        var confetti = findViewById<GifImageView>(R.id.readyGameConfetti)
        confetti.visibility = View.INVISIBLE

        var tshirt_colors: MutableList<String> = mutableListOf<String>("red", "yellow", "blue", "purple", "orange")
        var shorts_colors: MutableList<String> = mutableListOf("blue", "green", "orange", "pink", "red", "white", "yellow")

        // get the containers for the the items of clothing
        val itemOfClothingViews: MutableList<ImageView> = mutableListOf()
        for (i in 1..3) {
            var viewId = "cloth_${i}"
            var resId = resources.getIdentifier(viewId, "id", packageName)
            var cloth = findViewById<ImageView>(resId)
            itemOfClothingViews.add(cloth)
        }

        // mode selection
        var mode = Random.nextInt(2) // 0 is tshirt 1 shorts

        var levelColor = ""
        var audio = resources.getIdentifier("red", "raw", packageName);
        var mediaPlayer = MediaPlayer.create(this, audio);

        if (mode == 0) {
            // select color for level
            var randomColor = Random.nextInt(tshirt_colors.size)
            levelColor = tshirt_colors[randomColor]
            audio = resources.getIdentifier("${levelColor}_tshirt", "raw", packageName);
        } else {
            // select color for level
            var randomColor = Random.nextInt(tshirt_colors.size)
            levelColor = shorts_colors[randomColor]
            audio = resources.getIdentifier("${levelColor}_shorts", "raw", packageName);

        }

        mediaPlayer = MediaPlayer.create(this, audio);

        var instructionText = findViewById<TextView>(R.id.readyGameInstruction)

        if (mode == 0) {
            instructionText.text = "Put the ${levelColor.uppercase()} T-shirt in the bin!"
        } else {
            instructionText.text = "Put the ${levelColor.uppercase()} shorts in the bin!"
        }



        for(i in itemOfClothingViews) {
            i.setOnClickListener {
                if (i.tag == levelColor) {
                    i.visibility = View.INVISIBLE
                    confetti.visibility = View.VISIBLE

                    try {
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop()
                        }
                        mediaPlayer.start()
                    } catch (e: Exception) {}

                    mediaPlayer.setOnCompletionListener {
                        var timer = Timer("schedule", true)
                        timer.schedule(4000){
                            val intent: Intent = intent
                            finish()
                            startActivity(intent)
                        }
                    }

                }
            }
        }

        itemOfClothingViews.shuffle()

        for (i in 0..2) {
            var cloth_drawable_name = "";
            var tag = ""
            var random = if (mode == 0) Random.nextInt(tshirt_colors.size) else Random.nextInt(shorts_colors.size)
            if (i == 0) {
                cloth_drawable_name = if (mode == 0) "tshirt_${levelColor}" else "shorts_${levelColor}"
                if (mode == 0) {
                    tshirt_colors.remove(levelColor)
                } else {
                    shorts_colors.remove(levelColor)
                }
                tag = levelColor
            } else {
                cloth_drawable_name = if (mode == 0) "tshirt_${tshirt_colors[random]}" else "shorts_${shorts_colors[random]}"
                tag = if (mode == 0) tshirt_colors[random] else shorts_colors[random]
                if (mode == 0) {
                    tshirt_colors.removeAt(random)
                } else {
                    shorts_colors.removeAt(random)
                }
            }

            var resource = resources.getIdentifier(cloth_drawable_name, "drawable", packageName)
            itemOfClothingViews[i].setImageResource(resource)
            itemOfClothingViews[i].tag = tag
        }

    }
}