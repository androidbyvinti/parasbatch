package com.android.pictoword

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var counter = 0
    var answerCount = 0

    var imageArray = arrayOf(R.drawable.foot, R.drawable.ball,
                            R.drawable.hour, R.drawable.glass,
                            R.drawable.key, R.drawable.board)

    var answerArray = arrayOf("Football", "hourglass", "keyboard")

    var buttonArray = intArrayOf(R.id.buttonOne, R.id.buttonTwo, R.id.buttonThree,
                                    R.id.buttonFour, R.id.buttonFive, R.id.buttonSix,
                                    R.id.buttonSeven,R.id.buttonEight, R.id.buttonNine,
                                    R.id.buttonTen, R.id.buttonEleven, R.id.buttonTwelve,
                                    R.id.buttonThirteen, R.id.buttonFourteen)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadImage()
        putAnswer()
        Log.d("Array", "length = " + answerArray[answerCount].length)
        setText()

    }
    fun setText(){
        var tempArray  = arrayListOf<Char>()
        //var tempArray = arrayOfNulls<Char>(answerArray[answerCount].length)
        for(i in 0 until answerArray[answerCount].length){
            tempArray.add(i, answerArray[answerCount][i])
            //tempArray[i-1] = answerArray[answerCount][i-1]
            Log.d("MainActivity","Data = " + tempArray[i])
        }
        Collections.shuffle(tempArray)
        Log.d("MainActivity", "size is = " + tempArray.size)
        for(i in 0..tempArray.size-1){

            //Log.d("MainActivity", "value is " + i+" = " + tempArray[i])
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

            answerButtonLayout.addView(button)
        }
    }
}