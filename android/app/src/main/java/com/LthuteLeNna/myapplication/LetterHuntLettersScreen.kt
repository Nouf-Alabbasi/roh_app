package com.LthuteLeNna.myapplication

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import java.lang.Exception
import kotlin.random.Random

class LetterHuntLettersScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter_hunt_letters_screen)

        try {
            supportActionBar?.hide()
        } catch(e: Exception) {}


        var colors: Array<String> = arrayOf("#ff1616","#85db79","#ffe000", "#a46ea6", "#06e5ef", "#a4adff", "#6a8edd", "#11d476", "#4cc8e5")

        var audio = resources.getIdentifier("a", "raw", packageName);
        var mediaPlayer = MediaPlayer.create(this, audio);

        for (i in 97..122) {
            var alphabet = i.toChar().toString()
            var viewId: String = alphabet
            var resId = resources.getIdentifier(viewId, "id", packageName)
            var letter = findViewById<TextView>(resId)

            var colorInd: Int = Random.nextInt(colors.size)
            letter.setTextColor(Color.parseColor(colors[colorInd]))

            letter.setOnClickListener {

                if  (mediaPlayer.isPlaying()){
                    mediaPlayer.stop()
                }

                audio = resources.getIdentifier(alphabet, "raw", packageName);
                mediaPlayer = MediaPlayer.create(this, audio);

                mediaPlayer.start()
            }

        }

        var nextScreen = findViewById<ImageButton>(R.id.practiceIcon)
        nextScreen.setOnClickListener {
            startActivity(Intent(this, LetterGameActivityScreen::class.java))
        }

        var goToGameMain = findViewById<ImageButton>(R.id.goToCountingGameMain)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, LetterGameHomeScreen::class.java))
        }

//        var viewId: String = "babyCowPos"+i.toString()
//        var resId = resources.getIdentifier(viewId,"id", packageName);
//        var cowPosition = findViewById<ImageView>(resId) as ImageView
//        babyCowPositions.add(cowPosition)

    }
}