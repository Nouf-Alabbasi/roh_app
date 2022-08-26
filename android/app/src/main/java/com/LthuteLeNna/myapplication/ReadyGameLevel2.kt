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
import java.util.*
import kotlin.concurrent.schedule
import kotlin.random.Random

class ReadyGameLevel2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ready_game_level2)

        try {
            supportActionBar?.hide()
        } catch (e: Exception) {}

        var goToGameMain = findViewById<ImageButton>(R.id.goToBontleGameMain2)
        goToGameMain.setOnClickListener {
            startActivity(Intent(this, GettingReadyGameHome::class.java))
        }

        var goToPracticeButton = findViewById<ImageButton>(R.id.practiceIcon)
        goToPracticeButton.setOnClickListener {
            startActivity(Intent(this, ShapesScreen::class.java))
        }

        // shirts
        var shirtsColorsShapes: MutableList<String> = mutableListOf("blue_circle", "green_circle", "pink_triangle") //audio not available "green_diamond", "pink_heart","yellow_star"

        // pants
        var shortsColors: MutableList<String> = mutableListOf("blue", "green", "orange", "pink", "white", "yellow") //audio not available "red"
        var pantsColors: MutableList<String> = mutableListOf("blue", "green", "purple", "yellow") //audio not available "pink"

        var confetti = findViewById<GifImageView>(R.id.readyGameConfetti)
        confetti.visibility = View.INVISIBLE

        var mode = "top"

        var bontleTop = findViewById<ImageView>(R.id.bontleTop)
        bontleTop.visibility = View.INVISIBLE

        var bontleBottom = findViewById<ImageView>(R.id.bontleBottom)
        bontleBottom.visibility = View.INVISIBLE

        var clothesOption: MutableList<ImageView> = mutableListOf()

        for (i in 1..3) {
            var viewId: String = "cloth${i}"
            var resId = resources.getIdentifier(viewId, "id", packageName)
            var clothView = findViewById<ImageView>(resId)
            clothesOption.add(clothView)
        }

        var instruction = findViewById<TextView>(R.id.readyGameInstruction)

        // top
        var random = Random.nextInt(shirtsColorsShapes.size)
        var correctOption = shirtsColorsShapes[random]
        var color = correctOption.split("_")[0]
        var shape = correctOption.split("_")[1]
        instruction.text = "Put the ${color} tshirt with a ${shape} on Bontle"


        for (i in 0..2) {
            var shirtDrawableName = ""
            var tag = ""
            if (i == 0) {
                shirtDrawableName = "tshirt_${correctOption}"
                shirtsColorsShapes.remove(correctOption)
                tag = correctOption

                //play instructions
                var inst = resources.getIdentifier(shirtDrawableName, "raw", packageName)
                var mediaPlayerinst = MediaPlayer.create(this, inst)

                mediaPlayerinst.start();

                //replay audio
                var repeat_inst = findViewById<ImageView>(R.id.imageView27)
                repeat_inst.setOnClickListener {
//            if (mediaPlayer_word.isPlaying()) {
                    mediaPlayerinst.stop()
//            }

                    var inst = resources.getIdentifier(shirtDrawableName, "raw", packageName);
                    var mediaPlayerinst = MediaPlayer.create(this, inst)
                    mediaPlayerinst.start()
                }
                //replay audio

            } else {
                random = Random.nextInt(shirtsColorsShapes.size)
                var option = shirtsColorsShapes[random]
                shirtDrawableName = "tshirt_${option}"
                shirtsColorsShapes.removeAt(random)
                tag = option
            }

            var resource = resources.getIdentifier(shirtDrawableName, "drawable", packageName)
            clothesOption[i].setImageResource(resource)
            clothesOption[i].tag = tag
        }
        clothesOption.shuffle()

        // bottom
        var bottomMode = Random.nextInt(2) // 0 is shorts, 1 is pants

        fun switchModeToBottom() {
            mode = "bottom"
            if (bottomMode == 0) {
                random = Random.nextInt(shortsColors.size)
                correctOption = shortsColors[random]
                instruction.text = "Put a ${correctOption} shorts on Bontle"

                //play instructions
                var shorts = "shorts_${correctOption}"
                var inst = resources.getIdentifier(shorts, "raw", packageName)
                var mediaPlayerinst = MediaPlayer.create(this, inst)

                mediaPlayerinst.start();

            } else {
                random = Random.nextInt(pantsColors.size)
                correctOption = pantsColors[random]
                instruction.text = "Put a ${correctOption} pants on Bontle"
                //play instructions
                var pants = "shorts_${correctOption}"
                var inst = resources.getIdentifier(pants, "raw", packageName)
                var mediaPlayerinst = MediaPlayer.create(this, inst)

                mediaPlayerinst.start();
            }

            for (i in 0..2) {
                var bottomDrawableName = ""
                var tag = ""
                if (i == 0) {
                    if (bottomMode == 0) {
                        bottomDrawableName = "shorts_${correctOption}"
                        shortsColors.remove(correctOption)
                    } else {
                        bottomDrawableName = "pants_${correctOption}"
                        pantsColors.remove(correctOption)
                    }
                    tag = correctOption
                } else {
                    var option = ""
                    if (bottomMode == 0) {
                        random = Random.nextInt(shortsColors.size)
                        option = shortsColors[random]
                        bottomDrawableName = "shorts_${option}"
                        shortsColors.removeAt(random)
                    } else {
                        random = Random.nextInt(pantsColors.size)
                        option = pantsColors[random]
                        bottomDrawableName = "pants_${option}"
                        pantsColors.removeAt(random)
                    }
                    tag = option
                }
                var resource = resources.getIdentifier(bottomDrawableName, "drawable", packageName)
                clothesOption[i].setImageResource(resource)
                clothesOption[i].tag = tag
            }

            clothesOption.shuffle()

            for (i in clothesOption) {
                i.visibility = View.VISIBLE
                i.setOnClickListener {
                    if (i.tag == correctOption) {
                        var audio = resources.getIdentifier("${i.tag}_shorts", "raw", packageName)

                        var bottomDrawableName = ""
                        if (bottomMode == 0) {
                            bottomDrawableName = "shorts_${i.tag}"
                            audio = resources.getIdentifier("${i.tag}_shorts", "raw", packageName)
                        } else {
                            bottomDrawableName = "pants_${i.tag}"
                            audio = resources.getIdentifier("${i.tag}_pants", "raw", packageName)
                        }

                        var resource = resources.getIdentifier(bottomDrawableName, "drawable", packageName)
                        bontleBottom.setImageResource(resource)
                        bontleBottom.visibility = View.VISIBLE

                        confetti.visibility = View.VISIBLE


                        var mediaPlayer = MediaPlayer.create(this, audio)

                        mediaPlayer.setOnCompletionListener {
                            var timer = Timer("schedule", true)
                            timer.schedule(4000){
                                val intent: Intent = intent
                                finish()
                                startActivity(intent)
                            }
                        }

                        mediaPlayer.start()
                    }
                    else{
                        var audio_wrongs = resources.getIdentifier("oh_no", "raw", packageName)
                        var mediaPlayer_wrongs = MediaPlayer.create(this, audio_wrongs)
                        mediaPlayer_wrongs.start()
                    }
                }
            }
        }

        // set listeners
        for (i in clothesOption) {
            i.setOnClickListener {

                if (i.tag == correctOption) {
                    var resourceName = "tshirt_${i.tag}"
                    var resource = resources.getIdentifier(resourceName, "drawable", packageName)

//                    var audio = resources.getIdentifier("${correctOption}_tshirt", "raw", packageName)
//                    var mediaPlayer = MediaPlayer.create(this, audio)
//
//                    mediaPlayer.start();

                    bontleTop.setImageResource(resource)
                    bontleTop.visibility = View.VISIBLE
                    i.visibility = View.INVISIBLE
                    i.setOnClickListener {
                        null
                    }

                    try {
                        var audio = resources.getIdentifier("tshirt_${i.tag}", "raw", packageName);
                        var mediaPlayer = MediaPlayer.create(this, audio);
                        mediaPlayer.start()

                        var timer = Timer("schedule", true);
                        timer.schedule(5000) {
                            if (mediaPlayer.isPlaying()) {
                                mediaPlayer.stop()
                            }
                            Thread(Runnable {
                                this@ReadyGameLevel2.runOnUiThread(java.lang.Runnable {
                                    switchModeToBottom()
                                })
                            }).start()

                        }

                    } catch(e: Exception) {
                        switchModeToBottom()
                    }
                }
                else{
                    var audio_wrong = resources.getIdentifier("oh_no", "raw", packageName)
                    var mediaPlayer_wrong = MediaPlayer.create(this, audio_wrong)
                    mediaPlayer_wrong.start()
                }
            }
        }

    }
}