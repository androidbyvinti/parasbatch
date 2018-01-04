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

class MainActivity : AppCompatActivity() {

    var counter = 0
    var answerCount = 0

    var imageArray = arrayOf(R.drawable.foot, R.drawable.ball,
                            R.drawable.hour, R.drawable.glass,
                            R.drawable.key, R.drawable.board)
    var ansTrack = 0
    var answerArray = arrayOf("FOOTBALL", "HOURGLASS", "KEYBOARD")
    var buttonAnwserArray = ArrayList<Button>()
    var tempArrayData = ArrayList<Char>()
    lateinit var buttonArray : Array<Button>
    var selectedAnsButton = HashMap<Int, Int>()
    var data : StringBuilder? = StringBuilder()
    lateinit var tempArray : ArrayList<Char>

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

    private fun tempData(){
        for(i in 'A'..'Z')
            tempArrayData.add(i)
    }

    private fun setText(){
        Log.i("MainActivity", "Set Text called")
        tempArray  = arrayListOf()
        //var tempArray = arrayOfNulls<Char>(answerArray[answerCount].length)
        for(i in 0 until answerArray[answerCount].length)
        {
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
        for(i in 0 until tempArray.size){

            buttonArray[i].text = tempArray[i].toString()
            Log.d("MainActivity", "size is = " + tempArray[i])
        }

    }

    private fun loadImage(){
        firstImageView.setImageResource(imageArray[counter])
        counter++
        secondImageView.setImageResource(imageArray[counter])
        counter++
    }

    private fun putAnswer(){

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
                if(button.text.isNotBlank()){
                    answerButtonClicked(button)
                }
            }
            buttonAnwserArray.add(button)
            answerButtonLayout.addView(button)
        }
    }

    private fun answerButtonClicked(view : View){
        var button = findViewById<Button>(view.id)

        //button.setBackgroundResource(Color.WHITE)
        ansTrack--
        Log.i("MainActivity","answer button clicked" + ansTrack)

        var button1 = findViewById<Button>(selectedAnsButton.getValue(buttonAnwserArray[ansTrack].id))
        button1.text = button.text
        button.text = ""
        button1.visibility = View.VISIBLE
    }

    fun buttonClicked(view : View) {
        if(buttonAnwserArray.size > ansTrack) {
                    var selectedButton = findViewById<Button>(view.id)
                    selectedButton.visibility = View.INVISIBLE
                    for(i in 0 until buttonAnwserArray.size){
                        if(buttonAnwserArray[i].text.isEmpty()){

                            buttonAnwserArray[i].text = selectedButton.text
                            selectedAnsButton.put(buttonAnwserArray[i].id, view.id)
                            ansTrack++
                            break
                        }
                    }
            }
        checkResult()
    }

    private fun checkResult(){
        if(buttonAnwserArray.size == ansTrack)
        {
            if(data!!.isNotEmpty()){
                Log.i("MainActivity", "Before Deletion Data is = " + data)

                data!!.delete(0, data!!.length)
                Log.i("MainActivity", "After Deletion Data is = " + data)
            }
            var i = 0
            for(i in 0 until buttonAnwserArray.size){
                data = data?.append(buttonAnwserArray[i].text.toString())
                Log.i("MainActivity", "inside for loop " + data)
            }

            if(data.toString().equals(answerArray[answerCount], true)) {
                Toast.makeText(this@MainActivity, "Match" + data, Toast.LENGTH_LONG).show()
                loadImage()
                answerCount++
                var temp = answerCount + 1


                for(i in 0 until buttonArray.size){
                    buttonArray[i].visibility = View.VISIBLE
                }

                levelButton.text = "Level $temp"
                answerButtonLayout.removeAllViews()
                putAnswer()
                setText()

            } else {
                data?.setLength(0)
                data = StringBuilder()

                Toast.makeText(this@MainActivity, "Not matched" + data, Toast.LENGTH_LONG).show()

                Log.i("MainActivity", "Data is = " + data)
            }
        }
    }
}