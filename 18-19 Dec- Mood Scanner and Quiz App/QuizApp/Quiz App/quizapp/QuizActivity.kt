package com.android.quizapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var intent = intent
        val value = intent.getIntExtra("request", 0)

        Toast.makeText(this, "Request is $value", Toast.LENGTH_LONG).show()
    }
}