package com.bmpl.skiplogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var accountCreated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieving data stored in SharedPreference
                                                        // FileName
        val sharedPreferences = getSharedPreferences("userdata", Context.MODE_PRIVATE)
        accountCreated = sharedPreferences.getBoolean("accountCreated", false)

        var handler = Handler()
        var run = Runnable {
            if(!accountCreated) {
                startActivity(Intent(this, RegisterActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, WelcomeActivity :: class.java))
                finish()
            }
        }
        handler.postDelayed(run, 2000)
    }
}
