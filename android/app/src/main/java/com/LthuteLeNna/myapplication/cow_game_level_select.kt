package com.LthuteLeNna.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView

class cow_game_level_select : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cow_game_level_select)

        try{
            supportActionBar?.hide()
        }catch (e:Exception){}

        var goToGameMain = findViewById<ImageButton>(R.id.goToCountingGameMain)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, cow_game_main_screen::class.java))
        }

        var level1Card = findViewById<CardView>(R.id.level_1_card)
        level1Card.setOnClickListener {
            startActivity(Intent(this, CowGameLevelOne::class.java))
        }

        var level2Card = findViewById<CardView>(R.id.level_2_card)
        level2Card.setOnClickListener {
            startActivity(Intent(this, CowGameLevelTwo::class.java))
        }

        var infoButton = findViewById<ImageButton>(R.id.infoIconCowGame2) as ImageButton
        infoButton.setOnClickListener{
//            if (player.isPlaying()) player.stop()
            startActivity(Intent(this, cowGameInstruction::class.java))
        }

    }
}