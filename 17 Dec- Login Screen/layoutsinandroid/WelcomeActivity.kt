package com.android.layoutsinandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var intent = intent
        var name = intent.getStringExtra("name")
        Toast.makeText(this,"Name is $name", Toast.LENGTH_LONG).show()

    }
}