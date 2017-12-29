package com.android.androidwidgets

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MediaPlayer class

        mediaPlayer = MediaPlayer.create(this, R.raw.song)

        playButton.setOnClickListener(this)
        pauseButton.setOnClickListener(this)
        stopButton.setOnClickListener(this)
        //mediaPlayer.start()
    }

    override fun onClick(view: View?) {

        when(view!!.id){
            playButton.id-> {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.song)
                    mediaPlayer.start()
                } else {
                    mediaPlayer.start()
                }
                //mediaPlayer.isLooping = true
            }
            pauseButton.id-> mediaPlayer.pause()
            stopButton.id-> {
                                mediaPlayer.stop()
                                mediaPlayer.release()
            }
        }

    }
}