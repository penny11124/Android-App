package com.example.togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.ToggleButton
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var image : ImageView
    lateinit var result : TextView
    lateinit var toggleButton: ToggleButton

    lateinit var spinner: Spinner
    lateinit var resultCountry : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.image)
        result = findViewById(R.id.result)
        toggleButton = findViewById(R.id.toggleButton)

        toggleButton.setOnCheckedChangeListener { CompondButton, isChecked ->
            if(isChecked) {
                image.visibility = View.INVISIBLE
                result.text = "The image is invisible."
            }
            else {
                image.visibility = View.VISIBLE
                result.text = "The image is visible."
            }
        }

        spinner = findViewById(R.id.spinnerCountry)
        resultCountry = findViewById(R.id.resultCountry)

        spinner.onItemSelectedListener = this

        var arrayAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries,
            android.R.layout.simple_spinner_item
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = arrayAdapter
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(parent != null) {
            resultCountry.text = parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}