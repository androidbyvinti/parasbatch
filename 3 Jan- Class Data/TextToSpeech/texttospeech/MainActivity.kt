package com.bmpl.texttospeech

import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textToSpeech = TextToSpeech(this, TextToSpeech.OnInitListener { i ->
            if (i == TextToSpeech.SUCCESS)
            {
                val result = textToSpeech!!.setLanguage(Locale.FRENCH)

                if (result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(this@MainActivity, "Language not supported", Toast.LENGTH_LONG).show()
                    speakButton.isEnabled = false
                } else {
                    speakButton.isEnabled = true
                    speak1()
                }
            }
        })

        speakButton.setOnClickListener{
                speak1()
            }
    }

    private fun speak1() {
        val text = speakEditText.text.toString()
        textToSpeech!!.speak(text, TextToSpeech.QUEUE_FLUSH, null)
    }

    //@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun speak() {
        val text = speakEditText.text.toString()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (textToSpeech != null) {
            textToSpeech!!.stop()
        }
    }
}