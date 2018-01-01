package com.android.videoview

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pathOfVideo = "android.resource://" + packageName + "/" + R.raw.small
        Log.d("path" , pathOfVideo)

        videoView.setVideoPath(pathOfVideo)
        videoView.setMediaController(MediaController(this))
        videoView.start()
    }

    override fun onBackPressed() {
        //AlertDialog
        var alertDialog = AlertDialog.Builder(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alertDialog.setView(R.layout.abc_alert_dialog_material)
        }

        alertDialog.setTitle("Exit")
        alertDialog.setMessage("Do you want to Exit?")
        alertDialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
            finish()
            //super.onBackPressed()
        })
        alertDialog.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            onResume()
        })
        alertDialog.setNeutralButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
            onResume()
        })
        alertDialog.show()

    }
}