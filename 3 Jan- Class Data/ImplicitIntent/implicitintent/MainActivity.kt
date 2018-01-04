package com.android.implicitintent

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendButton.setOnClickListener {

            try {
                var intent = Intent() //ActivityManager -> look into device
                intent.putExtra(Intent.EXTRA_TEXT, "This is my data")
                //intent.`package` = "com.w"
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("abc@gmail.com"))
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain" // MIME Type in android
                startActivity(Intent.createChooser(intent, "Select One"))

            }catch (e : ActivityNotFoundException){
                Toast.makeText(this, "No App to handle this data. Kindly install webapp", Toast.LENGTH_LONG).show()
            } catch (e : Exception){
                Toast.makeText(this, "No App to handle this data. Kindly install webapp", Toast.LENGTH_LONG).show()
            }
        }
    }
}
