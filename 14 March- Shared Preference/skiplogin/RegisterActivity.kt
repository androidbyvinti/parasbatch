package com.bmpl.skiplogin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*



class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerButton.setOnClickListener {

            //SharedPreference

            val editor = getSharedPreferences("userdata", Context.MODE_PRIVATE).edit()
            editor.putBoolean("accountCreated", true)
            editor.apply()
        }

    }
}
