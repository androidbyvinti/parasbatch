package com.bmpl.speechtotext

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val REQ_CODE_SPEECH_INPUT = 1
    private val REQ_CODE_CAMERA_INPUT = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSpeak.setOnClickListener{
                promptSpeechInput()
            }
    }

    private fun promptSpeechInput() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT)

        } catch (a: ActivityNotFoundException) {
            Toast.makeText(applicationContext,
                    "Not supported",
                    Toast.LENGTH_SHORT).show()
    }catch (e: Exception){
            Toast.makeText(applicationContext,
                    "Some other exception occured",
                    Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        when (requestCode) {
            REQ_CODE_SPEECH_INPUT -> {
                if (resultCode == Activity.RESULT_OK && intent != null) {

                    val result = intent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    txtSpeechInput!!.text = result[0]
                }
            }
            REQ_CODE_CAMERA_INPUT -> {}
        }
    }
}