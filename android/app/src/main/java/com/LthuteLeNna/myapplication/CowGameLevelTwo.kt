// ##I think this text goes here

//// audio wrong answer
//var audio_wrong = resources.getIdentifier("oh_no", "raw", packageName)
//var mediaPlayer_wrong = MediaPlayer.create(this, audio_wrong)
//mediaPlayer_wrong.start()

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

class CowGameLevelTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cow_game_level_two)

        try {
            supportActionBar?.hide()
        } catch (e: Exception){}

        val goToGameMain = findViewById<ImageButton>(R.id.goToCountingGameMain2) as ImageButton
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, cow_game_main_screen::class.java))
        }

        val numCowsToSelectInTruck = Random.nextInt(1,10)

        val instructionText: TextView = findViewById(R.id.cGameL2_instructionText)
        val numCowsLeftAfterGame: TextView = findViewById(R.id.foundCowsNumber) as TextView

//        var audio_wrong = resources.getIdentifier("d", "raw", packageName)
//        var mediaPlayer_wrong = MediaPlayer.create(this, audio_wrong)
////        var goToHomeButton = findViewById<ImageButton>(R.id.goToCountingGameMain2)
////        goToHomeButton.setOnClickListener {
////            startActivity(Intent(this, Home::class.java))
////        }

        var practiceButton = findViewById<ImageButton>(R.id.cowGameLevel2Practice)
        practiceButton.setOnClickListener {
            startActivity(Intent(this, cow_game_numbers_screen::class.java))
        }

        val confettiGif = findViewById<GifImageView>(R.id.cowGameLevel2Confetti)
        confettiGif.visibility = View.INVISIBLE

        instructionText.text = "Put ${numCowsToSelectInTruck} ${if (numCowsToSelectInTruck==1) "cow" else "cows"} in the truck"

        var babyCows: MutableList<ImageView> = mutableListOf<ImageView>()
        for (i in 1..10) {
            val viewId:String = "cGameL2_BabyCow${i}"
            val resId = resources.getIdentifier(viewId, "id", packageName)
            val babyCow = findViewById<ImageView>(resId) as ImageView
            babyCows.add(babyCow)
        }

        val numCowsToDisplay = Random.nextInt(numCowsToSelectInTruck+1,10)
        for (i in numCowsToDisplay+1..10) {
            babyCows[i-1].visibility = View.INVISIBLE
            babyCows[i-1].visibility = View.GONE
        }


        numCowsLeftAfterGame.text = (numCowsToDisplay - numCowsToSelectInTruck).toString()
        numCowsLeftAfterGame.visibility = View.INVISIBLE

        var numCowsPutInTruck = 0

//        var audio = resources.getIdentifier("babies{numCowsToSelectInTruck}", "raw", packageName);
//        var mediaPlayer_start = MediaPlayer.create(this, audio)
//
//        mediaPlayer_start.start();
//
//        //replay audio
//        var repeat_inst = findViewById<ImageView>(R.id.MamaCow)
//        repeat_inst.setOnClickListener {
//            if (mediaPlayer_start.isPlaying()) {
//                mediaPlayer_start.stop()
//            }
//
//            var audio = resources.getIdentifier("babies{numCowsToSelectInTruck}", "raw", packageName);
//            var mediaPlayer_start = MediaPlayer.create(this, audio)
//            mediaPlayer_start.start()
//        }
//        //replay audio


        var cowsInTruck: MutableList<ImageView> = mutableListOf<ImageView>()
        for (i in 1..10) {
            val viewId: String = "cGameL2_cowInTruck${i}"
            val resId = resources.getIdentifier(viewId,"id", packageName)
            val cowInTruck = findViewById<ImageView>(resId) as ImageView
            cowInTruck.visibility = View.GONE
            cowsInTruck.add(cowInTruck)
        }

        fun removeOnClickListeners() {
            for (i in babyCows) {
                i.setOnClickListener(null)
            }
        }



        fun startGameTwo(){
            practiceButton.setImageResource(R.drawable.next_button)
            practiceButton.setOnClickListener {
                startActivity(Intent(this, CowGameLevelTwo::class.java))
            }

//            var mediaPlayer_left = MediaPlayer.create(this, R.raw.left);
//            mediaPlayer_left.start();


            var audio = resources.getIdentifier("how_many_babies_are_left_", "raw", packageName);
            var mediaPlayer_G2 = MediaPlayer.create(this, audio)
            mediaPlayer_G2.start()

            //replay audio
            var repeat_inst = findViewById<ImageView>(R.id.imageView15)
            repeat_inst.setOnClickListener {
                if (mediaPlayer_G2.isPlaying()) {
                    mediaPlayer_G2.stop()
                }

                var audio = resources.getIdentifier("how_many_babies_are_left_", "raw", packageName);
                var mediaPlayer_G2 = MediaPlayer.create(this, audio)
                mediaPlayer_G2.start()
            }
            //replay audio

            instructionText.text = "How many cows are left?"
            instructionText.visibility = View.VISIBLE
            confettiGif.visibility = View.INVISIBLE
            var selectNumList : MutableList<TextView> = mutableListOf<TextView>()
            for (i in 1..3) {
                val viewId = "selectText${i}"
                val resId = resources.getIdentifier(viewId, "id", packageName)
                val selectNum = findViewById<TextView>(resId) as TextView
//                selectNum.visibility = View.VISIBLE
                selectNumList.add(selectNum)
            }

            val randomInd = Random.nextInt(0,2)
            var options = mutableListOf<Int>()
            for (i in 0..2) {
                // if it is the correct answer's position
                if (i == randomInd) {
                    selectNumList[i].text = (numCowsToDisplay - numCowsToSelectInTruck).toString()
                    options.add(numCowsToDisplay - numCowsToSelectInTruck)
                    selectNumList[i].setOnClickListener {

                        confettiGif.visibility = View.VISIBLE
                        numCowsLeftAfterGame.visibility = View.VISIBLE
                        selectNumList[i].setOnClickListener { null }
                        for (i in selectNumList) {
                            i.visibility = View.INVISIBLE
                        }

                        var audio_yayyy = resources.getIdentifier("yayyy", "raw", packageName);
                        var mediaPlayer_yayyy = MediaPlayer.create(this, audio_yayyy)
                        mediaPlayer_yayyy.start()

                        var audioNum = resources.getIdentifier("num${selectNumList[i].text}", "raw", packageName)
                        var audioNumMediaPlayer = MediaPlayer.create(this, audioNum);

//                        if (mediaPlayer_left.isPlaying()) mediaPlayer_left.stop()
                        if (mediaPlayer_G2.isPlaying()) mediaPlayer_G2.stop()

                        audioNumMediaPlayer.start()

                        var timer = Timer("schedule", true)
                        timer.schedule(5000){
                            val intent: Intent = intent
                            finish()
                            if (audioNumMediaPlayer.isPlaying()) audioNumMediaPlayer.stop();
                            startActivity(intent)
                        }
                    }
                } else {
                    var randomNum = Random.nextInt(1,10)
                    while (randomNum.toString() == selectNumList[randomInd].text) { // so that we dont have repeated correct option
                        randomNum = Random.nextInt(1,10)
                    }
                    while (randomNum in options) { // so that we dont have repeated options
                        randomNum = Random.nextInt(1,10)
                    }
                    selectNumList[i].text = randomNum.toString()

                    selectNumList[i].setOnClickListener {
                        // audio wrong answer
                        try {
                            var audio_wrong = resources.getIdentifier("oh_no", "raw", packageName)
                            var mediaPlayer_wrong = MediaPlayer.create(this, audio_wrong)
                            mediaPlayer_wrong.start()
                        } catch (e: Exception){}
                    }

                }
                selectNumList[i].visibility = View.VISIBLE
            }
        }


        for (i in 0..numCowsToDisplay-1) {
            babyCows[i].setOnClickListener{
                numCowsPutInTruck++
                babyCows[i].visibility = View.INVISIBLE
                cowsInTruck[numCowsPutInTruck-1].visibility = View.VISIBLE
                babyCows[i].setOnClickListener(null)
                if (numCowsPutInTruck == numCowsToSelectInTruck) {
                    // display the confetti with the number
                    instructionText.visibility = View.INVISIBLE
                    removeOnClickListeners()
                    confettiGif.visibility = View.VISIBLE
                    var timer = Timer("schedule", true)
                    timer.schedule(4000){
                        Thread(Runnable {
                            this@CowGameLevelTwo.runOnUiThread(java.lang.Runnable {
                                startGameTwo()
                            })
                        }).start()
                    }
                }
            }
        }
    }
}