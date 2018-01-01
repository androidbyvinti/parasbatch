package com.bmpl.customadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var images = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                                R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                                R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                                R.mipmap.ic_launcher, R.mipmap.ic_launcher)

        var data = arrayOf("Data1", "Data2",
                            "Data3", "Data4",
                            "Data5", "Data6",
                            "Data7", "Data8")

        var listView : ListView = findViewById(R.id.listView) as ListView

        var adapter = CustomAdapter(this, images, data)

        listView.adapter =  adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->

        }


    }
}
