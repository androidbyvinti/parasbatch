package com.android.layoutsinandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // R is predefined class in android --> id of all the resources used in project

        signUpButton.setOnClickListener {
            // create an object of Intent class
            // Intent intent = new Intent();
            var name = nameEditText.text.toString()

            var intent = Intent(this, WelcomeActivity :: class.java )   // explicit intent--> source and destination
            intent.putExtra("name", name)// String (Key), String (Value)
            //predefined method --> startActivity(intent)
            startActivity(intent) // AppCompat --> EmptyActivity or BlankActivity or GoogleActivity
        }

    }
}
