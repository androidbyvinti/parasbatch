package com.android.activitylifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "inside onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "inside onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "inside onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "inside onPause()")
    }


    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "inside onStop()")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("MainActivity", "inside onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "inside onRestart()")
    }
}
