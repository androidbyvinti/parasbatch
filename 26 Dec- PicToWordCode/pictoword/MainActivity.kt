package com.android.pictoword

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    var counter = 0
    var answerCount = 0

    var imageArray = arrayOf(R.drawable.foot, R.drawable.ball,
                            R.drawable.hour, R.drawable.glass,
                            R.drawable.key, R.drawable.board)
    var ansTrack = 0

    var answerArray = arrayOf("Football", "hourglass", "keyboard")
    var buttonAnwserArray = ArrayList<Button>()
    var tempArrayData = ArrayList<Char>()
    lateinit var buttonArray : Array<Button>

    var selectedAnsButton = HashMap<Int, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonArray = arrayOf (buttonOne, buttonTwo, buttonThree,
                                buttonFour, buttonFive, buttonSix,
                                buttonSeven,buttonEight, buttonNine,
                                buttonTen, buttonEleven, buttonTwelve,
                                buttonThirteen, buttonFourteen)
        tempData()
        loadImage()
        putAnswer()
        Log.d("Array", "length = " + answerArray[answerCount].length)
        setText()
    }

    fun tempData(){
        for(i in 'A'..'Z')
            tempArrayData.add(i)
    }

    fun setText(){
        var tempArray  = arrayListOf<Char>()
        //var tempArray = arrayOfNulls<Char>(answerArray[answerCount].length)
        for(i in 0 until answerArray[answerCount].length){
            tempArray.add(i, answerArray[answerCount][i])
            //tempArray[i-1] = answerArray[answerCount][i-1]
            Log.d("MainActivity","Data = " + tempArray[i])
        }
        Collections.shuffle(tempArrayData)
        Log.d("MainActivity", "size is = " + tempArray.size)

        for(i in tempArray.size..13){
            tempArray.add(tempArrayData[i])
            //buttonArray[i].text = tempArrayData[i].toString()
        }
        Collections.shuffle(tempArray)
        for(i in 0..tempArray.size-1){

            buttonArray[i].text = tempArray[i].toString()
        }

    }

    fun loadImage(){
        firstImageView.setImageResource(imageArray[counter])
        counter++
        secondImageView.setImageResource(imageArray[counter])
        counter++
    }

    fun putAnswer(){

        for(i in 1..answerArray[answerCount].length){

            var button = Button(this)
            var layoutParams = WindowManager.LayoutParams()
            layoutParams.width = 100
            layoutParams.height = 180
            button.layoutParams = layoutParams
            button.setBackgroundResource(R.drawable.circular_shape)
            button.setTextColor(Color.BLACK)
            button.id = i

            button.setOnClickListener{
                answerButtonClicked(button)
            }
            buttonAnwserArray.add(button)
            answerButtonLayout.addView(button)
        }
    }

    fun answerButtonClicked(view : View){
        var button = findViewById<Button>(view.id)
        button.text = ""
        //button.setBackgroundResource(Color.WHITE)
        ansTrack--
        var button1 = findViewById<Button>(selectedAnsButton.getValue(buttonAnwserArray[ansTrack].id))
        button1.visibility = View.VISIBLE
    }

    fun buttonClicked(view : View)
    {
        when{
            buttonAnwserArray.size > ansTrack -> {
                var selectedButton = findViewById<Button>(view.id)
                selectedButton.visibility = View.INVISIBLE
                buttonAnwserArray[ansTrack].text = selectedButton.text
                selectedAnsButton.put(buttonAnwserArray[ansTrack].id, view.id)
                ansTrack++
            }
            buttonAnwserArray.size == ansTrack -> {

            }
            else -> Toast.makeText(this, "Try again...", Toast.LENGTH_LONG).show()
        }
    }
}