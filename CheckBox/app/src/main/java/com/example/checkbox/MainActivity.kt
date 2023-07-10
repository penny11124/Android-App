package com.example.checkbox

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var male : CheckBox
    lateinit var female : CheckBox
    lateinit var result : TextView

    lateinit var constraintLayout: ConstraintLayout
    lateinit var green : RadioButton
    lateinit var yellow : RadioButton
    lateinit var red : RadioButton
    lateinit var change : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        male = findViewById(R.id.checkBoxMale)
        female = findViewById(R.id.checkBoxFemale)
        result = findViewById(R.id.textViewResult)

        male.setOnClickListener {
            if(male.isChecked) {
                result.text = "Your gender is Male."
                female.isChecked = false
            }
            else {
                result.text = "What's your gender?"
            }
        }

        female.setOnClickListener {
            if(female.isChecked) {
                result.text = "Your gender is Female."
                male.isChecked = false
            }
            else {
                result.text = "What's your gender?"
            }
        }

        constraintLayout = findViewById(R.id.constraintLayout)
        green = findViewById(R.id.radioButtonGreen)
        yellow = findViewById(R.id.radioButtonYellow)
        red = findViewById(R.id.radioButtonRed)
        change = findViewById(R.id.buttonChange)

        change.setOnClickListener {
            if(green.isChecked) {
                constraintLayout.setBackgroundColor(Color.GREEN)
            }
            else if(yellow.isChecked) {
                constraintLayout.setBackgroundColor(Color.YELLOW)
            }
            else if(red.isChecked) {
                constraintLayout.setBackgroundColor(Color.RED)
            }
        }

    }
}