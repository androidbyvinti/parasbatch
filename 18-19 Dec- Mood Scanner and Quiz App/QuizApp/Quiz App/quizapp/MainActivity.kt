package com.android.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var delayMillisecond = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var handler = Handler()

        var run = Runnable {
            startActivity(Intent(this, MenuActivity :: class.java))
            finish()
        }

        handler.postDelayed(run, delayMillisecond)

    }
}
