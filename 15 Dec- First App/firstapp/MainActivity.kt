package com.android.firstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2 EditText , 2 Buttons, 1 TextView

        // widget -->events listener and event handler

        submitButton.setOnClickListener {

            var first = firstEditText.text.toString().toInt()
            var second = secondEditText.text.toString().toInt()

            var result = first + second

            resultTextView.text = result.toString()

        }

    }
}
