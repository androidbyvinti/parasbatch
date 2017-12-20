package com.android.quizapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity(), View.OnClickListener {

    // void onClick(view : View?) // optional -->it contains value or may contain any value

    override fun onClick(view : View?) {
        var value = when(view!!.id){
            cButton.id -> 1
            cPlusButton.id -> 2
            javaButton.id -> 3
            kotlinButton.id -> 4
            androidButton.id -> 5
            else-> 0
        }
        var intent = Intent(this, QuizActivity :: class.java)
            intent.putExtra("request", value)
            startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        cButton.setOnClickListener(this)
        cPlusButton.setOnClickListener(this)
        javaButton.setOnClickListener(this)
        kotlinButton.setOnClickListener(this)
        androidButton.setOnClickListener(this)

    }
}