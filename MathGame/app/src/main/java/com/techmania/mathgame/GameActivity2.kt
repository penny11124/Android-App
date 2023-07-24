package com.techmania.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Locale

class GameActivity2 : AppCompatActivity() {
    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTime : TextView
    lateinit var textQuestion : TextView
    lateinit var editTextAnswer : EditText
    lateinit var buttonOK : Button
    lateinit var buttonNext : Button

    var correctAnswer = 0
    var userScore = 0
    var userLife = 3

    lateinit var timer : CountDownTimer
    private val startTimerInMillis : Long = 31000
    var timeLeftInMillis : Long = startTimerInMillis

    private var isAnswered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        supportActionBar!!.title = "Subtraction"

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)
        textQuestion = findViewById(R.id.textViewQuestion)
        editTextAnswer = findViewById(R.id.editTextAnswer)
        buttonOK = findViewById(R.id.buttonOK)
        buttonNext = findViewById(R.id.buttonNext)

        gameContinue()

        buttonOK.setOnClickListener {
            val input = editTextAnswer.text.toString()
            if (!isAnswered) {
                if(input == "") {
                    Toast.makeText(applicationContext,"Please write an answer or click the NEXT button.",
                        Toast.LENGTH_SHORT).show()

                } else {
                    pauseTimer()
                    val userAnswer = input.toInt()
                    if(userAnswer == correctAnswer) {
                        userScore += 10
                        textQuestion.text = "CORRECT!"
                        textScore.text = userScore.toString()
                    } else {
                        userLife -= 1
                        textQuestion.text = "WRONG ANSWER ><"
                        textLife.text = userLife.toString()
                    }
                    isAnswered = true
                }
            }
        }

        buttonNext.setOnClickListener {
            pauseTimer()
            resetTimer()
            editTextAnswer.setText("")
            isAnswered = false

            if(userLife == 0) {
                Toast.makeText(applicationContext,"Game Over", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@GameActivity2,ResultActivity::class.java)
                intent.putExtra("score",userScore)
                startActivity(intent)
                finish()
            } else {
                gameContinue()
            }
        }

    }

    fun gameContinue() {
        val number1 = kotlin.random.Random.nextInt(0,100)
        val number2 = kotlin.random.Random.nextInt(0,100)

        if(number1 > number2) {
            textQuestion.text = "$number1 - $number2"
            correctAnswer = number1 - number2
        } else {
            textQuestion.text = "$number2 - $number1"
            correctAnswer = number2 - number1
        }

        startTimer()
    }

    fun startTimer() {
        timer = object : CountDownTimer(timeLeftInMillis,1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateText()
            }

            override fun onFinish() { //計時結束後發生什麼事
                pauseTimer()
                resetTimer()
                updateText()

                userLife--
                textLife.text = userLife.toString()
                textQuestion.text = "Time's UP!"
            }
        }.start()
    }

    fun updateText() {
        val remainingTime : Int = (timeLeftInMillis/1000).toInt()
        textTime.text = String.format(Locale.getDefault(),"%02d",remainingTime)
    }

    fun pauseTimer() {
        timer.cancel()
    }

    fun resetTimer() {
        timeLeftInMillis = startTimerInMillis
        updateText()
    }
}