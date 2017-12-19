package com.android.moodscanner

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var moods = arrayOf("Playing", "Dancing", "Studying", "Reading", "Coding")

        var delayMillisecond = 1000L

        thumbImageView.setOnClickListener {

            thumbImageView.setBackgroundResource(R.drawable.frame_animation)

            var animation = thumbImageView.background as AnimationDrawable

            animation.start()

            var handler = Handler()

            var run = Runnable {    // interface

                var random = Random()
                var value = random.nextInt(moods.size)
                resultTextView.text = moods[value]
                animation.stop()
                thumbImageView.setBackgroundResource(R.drawable.fingerprint)

            }

            handler.postDelayed(run, delayMillisecond)

            //var delay

        }

    }
}