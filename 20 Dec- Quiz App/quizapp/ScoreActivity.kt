package com.android.quizapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        var score = intent// getIntent()
        scoreTextView.text = "Score : " + score.getIntExtra("score", 0).toString()
    }
}
