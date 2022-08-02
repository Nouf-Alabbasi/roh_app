package com.LthuteLeNna.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception
import kotlin.random.Random

class WordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToImagineGameMain4)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, WordsMain::class.java))
        }

        var nextButton = findViewById<ImageButton>(R.id.nextWord)
        nextButton.setOnClickListener {
            finish()
            startActivity(intent)
        }

        var level1Characters: MutableList<String> = mutableListOf("lion", "cat", "dog", "cow", "boy", "girl", "monkey", "elephant", "chicken", "ant")
        var level1Objects:  MutableList<String> = mutableListOf("hat", "bag", "doll", "teddy bear", "bowl", "soap", "tap", "chair", "book")

        var level2Places: MutableList<String> = mutableListOf("village", "school", "hospital", "house", "bush", "garden", "river", "tuck shop", "church")
        var level2Activities: MutableList<String> =  mutableListOf("running", "jumping", "eating", "bathing", "dancing", "sleeping", "reading", "playing", "singing", "shopping")

        var level3Characters: MutableList<String> =  mutableListOf("grandfather", "grandmother", "baby", "fish", "bird", "butterfly", "mother", "father", "rhino")
        var level3Places: MutableList<String> =  mutableListOf("road", "mountain", "kitchen", "toilet", "desert", "playground", "sand pit")
        var level3Objects: MutableList<String> =  mutableListOf("pencil", "eraser", "notebook", "socks", "dress", "paper", "shoes", "fork", "spoon")
        var level3Activities: MutableList<String> =  mutableListOf("crying", "listening", "walking", "sharing", "laughing", "drawing")

        var randomIndex = 0
        var category: String =  intent.getStringExtra("wordSet").toString()
        var randomWord: String = ""

        if (category == "level1Character") {
            randomIndex = Random.nextInt(level1Characters.size)
            randomWord = level1Characters[randomIndex]

        } else if (category == "level1Objects") {
            randomIndex = Random.nextInt(level1Objects.size)
            randomWord = level1Objects[randomIndex]

        } else if (category == "level2Places") {
            randomIndex = Random.nextInt(level2Places.size)
            randomWord = level2Places[randomIndex]

        } else if (category == "level2Activities") {
            randomIndex = Random.nextInt(level2Activities.size)
            randomWord = level2Activities[randomIndex]

        } else if (category == "level3Characters") {
            randomIndex = Random.nextInt(level3Characters.size)
            randomWord = level3Characters[randomIndex]

        } else if (category == "level3Places") {
            randomIndex = Random.nextInt(level3Places.size)
            randomWord = level3Places[randomIndex]

        } else if (category == "level3Objects") {
            randomIndex = Random.nextInt(level3Objects.size)
            randomWord = level3Objects[randomIndex]

        } else if (category == "level3Activities") {
            randomIndex = Random.nextInt(level3Activities.size)
            randomWord = level3Activities[randomIndex]

        }

        var audio = resources.getIdentifier(randomWord, "raw", packageName);

        var drawableName = "word_${randomWord.split(" ").joinToString("_")}"
        randomWord = randomWord[0].uppercase() + randomWord.substring(1)

        var wordView = findViewById<TextView>(R.id.word)
        var wordImageView = findViewById<ImageView>(R.id.wordImage)

        wordView.text = randomWord

        var resource = resources.getIdentifier(drawableName, "drawable", packageName)
        wordImageView.setImageResource(resource)

        var playButton = findViewById<ImageView>(R.id.audio_play)


        var mediaPlayer = MediaPlayer.create(this, audio)
        playButton.setOnClickListener {
            mediaPlayer.start()
        }


    }
}