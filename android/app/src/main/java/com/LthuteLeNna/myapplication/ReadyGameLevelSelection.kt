package com.LthuteLeNna.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class ReadyGameLevelSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready_game_level_selection)

        try {
            supportActionBar?.hide()
        } catch(e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToBontleGameMain3)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, GettingReadyGameHome::class.java))
        }

        var level1Card = findViewById<CardView>(R.id.level1Card)
        level1Card.setOnClickListener {
            startActivity(Intent(this, ColorsScreen::class.java))
        }

        var level2Card = findViewById<CardView>(R.id.level2Card)
        level2Card.setOnClickListener {
            startActivity(Intent(this, ShapesScreen::class.java))
        }

        var infoButton = findViewById<ImageButton>(R.id.infoIconGetReadyGame3) as ImageButton
        infoButton.setOnClickListener{
//            if (player.isPlaying()) player.stop()
            startActivity(Intent(this@ReadyGameLevelSelection, readyGameInstructionScreen::class.java))
        }

    }
}