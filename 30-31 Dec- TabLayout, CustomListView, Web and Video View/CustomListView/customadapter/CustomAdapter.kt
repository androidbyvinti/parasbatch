package com.bmpl.customadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter: BaseAdapter{

    //LayoutInflater class--> layout show with adapter class

    var images  : IntArray
    lateinit var values : Array<String>//instance var-->outside the constructor or method
    lateinit var context : Context

    lateinit var layoutinflater : LayoutInflater

    constructor(mainActivity: MainActivity, images: IntArray, data: Array<String>){
        //local variable

        context = mainActivity
        this.images = images
        values = data
        //layoutinflater class-->
        layoutinflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    }


    //return result view which should be displayed on screen
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

        var view : View = layoutinflater.inflate(R.layout.customadapter, viewGroup, false)



        var imageView : ImageView = view.findViewById(R.id.imageView) as ImageView

        var textView : TextView  = view.findViewById(R.id.textView) as TextView

        imageView.setImageResource(images[position])
        textView.text = values[position]

        return view
    }

    //return item included in the view
    override fun getItem(index: Int): Any {
        return images[index]
    }
    //return id associated with the item
    override fun getItemId(id: Int): Long {
        return id.toLong()
    }
    //return total count of items
    override fun getCount(): Int {
        return images.size
    }

}