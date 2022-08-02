package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import pl.droidsonroids.gif.GifImageView
import java.util.*
import kotlin.concurrent.schedule
import kotlin.random.Random

class LetterGameActivityScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter_game_screen)

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var confetti = findViewById<GifImageView>(R.id.letterGameConfetti)
        confetti.visibility = View.INVISIBLE

        // hide won images
        var wonImageTop = findViewById<ImageView>(R.id.wonImageTop)
        var wonImageBottom = findViewById<ImageView>(R.id.wonImageBottom)

        wonImageTop.visibility = View.INVISIBLE
        wonImageBottom.visibility = View.INVISIBLE

        var goToGameMain = findViewById<ImageButton>(R.id.letterHuntHomeButton)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, LetterGameHomeScreen::class.java))
        }

        var practiceIcon = findViewById<ImageButton>(R.id.letterHuntPractice)
        practiceIcon.setOnClickListener {
            startActivity(Intent(this, LetterHuntLettersScreen::class.java))
        }

        var listOfWords:  Array<String> = arrayOf("dog", "log", "cat", "hat", "cow", "pig", "red", "boy", "egg", "tap", "bag", "bat", "mop", "jam", "dot")

        // possible letter options to choose from
        val letterOptions: MutableList<TextView> = mutableListOf()
        for (i in 1..5) {
            var viewId: String = "letter${i}"
            var resId = resources.getIdentifier(viewId, "id", packageName)
            var letterOption = findViewById<TextView>(resId)
//            letterOption.text = ""
            letterOptions.add(letterOption)
        }

        var selectedWord = listOfWords[Random.nextInt(listOfWords.size)]

        letterOptions.shuffle()

        for (i in 0..4) {
            if (i<3) {
                letterOptions[i].text = selectedWord[i].toString().uppercase()

            } else {
                letterOptions[i].text = (Random.nextInt(26)+65).toChar().toString()
            }
            letterOptions[i].tag = letterOptions[i].text
        }

        val letterPositions: MutableList<TextView> = mutableListOf()
        for (i in 1..3) {
            var viewId = "position${i}"
            var resId = resources.getIdentifier(viewId, "id", packageName)
            var letterPosition = findViewById<TextView>(resId)
            letterPosition.tag = selectedWord[i-1]
            letterPosition.text = ""
            letterPositions.add(letterPosition)
        }

        var activePosition:TextView = letterPositions[0];
        activePosition.setBackgroundResource(R.drawable.letter_spot_green)

        // to select a position to put the letters in
        for (i in 0..2) {
            letterPositions[i].setOnClickListener {
                activePosition = letterPositions[i]
                for (j in 0..2) {
                    if (i == j) {
                        letterPositions[j].setBackgroundResource(R.drawable.letter_spot_green)
                    } else {
                        letterPositions[j].setBackgroundResource(R.drawable.letter_spot_blue)
                    }
                }
            }
        }

        fun displayWonImage(word: String) {
            var img = findViewById<ImageView>(R.id.girl)
            var resource = resources.getIdentifier(word, "drawable", packageName)

            var replaceGirlImageWords = arrayOf("hat", "egg", "bag", "bat", "mop")
            var replaceTopImageWords = arrayOf("dot", "red")
            var replaceBottomImageWords = arrayOf("dog", "log", "cat", "cow", "pig", "boy", "jam")

            if (word in replaceBottomImageWords) {
                img = findViewById<ImageView>(R.id.wonImageBottom)
            }

            if (word in replaceTopImageWords) {
                img = findViewById(R.id.wonImageTop)
            }

            img.setImageResource(resource)
            img.visibility = View.VISIBLE
        }

        letterOptions.forEachIndexed { index, letterOption ->
            letterOption.setOnClickListener {

                // if the selected position is not empty
                if (activePosition.text != "") {
                    for (i in letterOptions) {
                        if (i.tag.toString() == activePosition.text) {
                            i.text = activePosition.text
                        }
                    }
                }

                activePosition.text = letterOption.text
                letterOption.text = ""

                // if the selected position is not correct
                if (activePosition.text != activePosition.tag.toString().uppercase()) {
                    var timer = Timer("schedule", true)
                    timer.schedule(500) {
                        Thread(Runnable {
                            this@LetterGameActivityScreen.runOnUiThread {
                                letterOption.text = activePosition.text
                                activePosition.text = ""
                            }
                        }).start()
                    }
                }

                var isCorrect = true
                for (i in 0..2) {
                    if (selectedWord[i].toString().uppercase() != letterPositions[i].text) {
                        isCorrect = false
                    }
                }

                // if correctly selected all letters
                if (isCorrect) {
                    for (i in letterPositions) {
                        i.setBackgroundResource(R.drawable.letter_spot_blue)
                        confetti.visibility = View.VISIBLE
                        displayWonImage(selectedWord)
                        for (j in letterOptions) {
                            j.setOnClickListener { null }
                        }

                        // play sound
                        var audio = resources.getIdentifier(selectedWord, "raw", packageName);
                        var mediaPlayer = MediaPlayer.create(this, audio)

                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                            mediaPlayer.start();
                        } else {
                            mediaPlayer.start();
                        }

                        mediaPlayer.setOnCompletionListener {
                            var timer = Timer("schedule", true)
                            timer.schedule(4000) {
                                startActivity(Intent(this@LetterGameActivityScreen, LetterGameActivityScreen::class.java))
                            }
                        }

                    }
                } else {

                }
            }
        }



    }
}