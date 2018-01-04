package com.bmpl.internalstorage_device

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {

    //Internal storage:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //File class --> location and name of file
        // path of sd card
        var pathOfFile = Environment.getExternalStorageDirectory()

        // path of internal storage
        var pathOfInternal = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)

        //Step-1: Create File --> Use File class --> createNewFile(), mkdir() or mkdirs(), etc
        var file = File(pathOfInternal, "data.doc")

        submitButton.setOnClickListener {

            var name = nameEditText.text.toString()
            var password = passwordEditText.text.toString()

            var fileWriter = FileWriter(file, true)
            fileWriter.write(name + "\n")
            fileWriter.write(password + "\n")

            Toast.makeText(this, "Data written", Toast.LENGTH_LONG).show()

            fileWriter.close()
        }

        loadButton.setOnClickListener {

//            var fileReader = FileReader(file)
//            while(fileReader.readText()!=null){
//
//                Toast.makeText(this, fileReader.readText(), Toast.LENGTH_LONG).show()
//            }

            val fileReader = FileReader(file)
            val bufferedReader = BufferedReader(fileReader)
            val data = bufferedReader.use { it.readText() }
            Toast.makeText(this, data, Toast.LENGTH_LONG).show()
        }
    }
}
