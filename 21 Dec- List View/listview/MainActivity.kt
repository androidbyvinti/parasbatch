package com.android.listview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var stringData = arrayOf("Data 1", "Data 2", "Data 3", "Data 4",
                                "Data 4", "Data 5", "Data 6", "Data 7",
                                "Data 8", "Data 9","Data 10", "Data 11",
                                "Data 12","Data 13","Data 13","Data 15")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayAdapter = ArrayAdapter(this, R.layout.custom_layout, stringData)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener {adapterView, view, index, id ->

            Toast.makeText(this, "You clicked on ${stringData[index]}", Toast.LENGTH_LONG).show()
        }

    }
}