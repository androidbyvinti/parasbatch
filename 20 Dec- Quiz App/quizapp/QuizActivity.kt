package com.android.quizapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    lateinit var questions : Array<String>
    lateinit var options : Array<String>
    lateinit var answers : Array<String>
    var counter = 0
    var score = 0
    lateinit var userChoice : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)



        var intent = intent
        val value = intent.getIntExtra("request", 0)

        userChoice = when(value){
            1-> {
                "C"
//                questions = resources.getStringArray(R.array.CQuestions)
//                options = resources.getStringArray(R.array.COptions)
//                answers = resources.getStringArray(R.array.CAnswers)
            }
            2->{
                "CPlus"

            }else->{""}
        }
        initializeArray()
        fetchQuestionOptions()
    }

    fun loadData(view : View){
        checkScore()
        counter++
        if(counter >= questions.size){
            var intent = Intent(this, ScoreActivity :: class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        } else {
            fetchQuestionOptions()
        }
    }

    fun checkScore(){
     var radioButton : RadioButton = findViewById(radioGroup.checkedRadioButtonId)

        if(radioButton.text == answers[counter]){
            score++
        }
    }
    fun fetchQuestionOptions(){
        questionTextView.text = questions[counter]
        option1.text = options[counter * 4]
        option2.text = options[counter * 4 + 1]
        option3.text = options[counter * 4 + 2]
        option4.text = options[counter * 4 + 3]
    }

    fun initializeArray(){
        var id = "R.array."
        //var question = userChoice.plus("Questions")
        questions = resources.getStringArray(id.plus(userChoice.plus("Questions")).toInt())
        options = resources.getStringArray(id.plus(userChoice.plus("Options")).toInt())
        answers = resources.getStringArray(id.plus(userChoice.plus("Answers")).toInt())
    }
}