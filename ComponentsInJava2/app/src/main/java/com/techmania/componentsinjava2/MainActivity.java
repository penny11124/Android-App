package com.techmania.componentsinjava2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    CheckBox male, female;
    TextView result;

    RadioGroup radioGroup;
    RadioButton green,red,yellow;
    Button ok;
    LinearLayout linearLayout;

    ToggleButton toggleButton;
    ImageView imageView;

    Spinner spinner;
    Adapter adapter;
    TextView spinnerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        male = findViewById(R.id.checkBoxMale);
        female = findViewById(R.id.checkBoxFemale);
        result = findViewById(R.id.textView);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(male.isChecked()) {
                    result.setText("Male");
                    female.setChecked(false);
                } else {
                    result.setText("What's your gender?");
                }
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(female.isChecked()) {
                    result.setText("Female");
                    male.setChecked(false);
                } else {
                    result.setText("What's your gender?");
                }
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        green = findViewById(R.id.radioButtonGreen);
        red = findViewById(R.id.radioButtonRed);
        yellow = findViewById(R.id.radioButtonYellow);
        ok = findViewById(R.id.buttonOk);
        linearLayout = findViewById(R.id.linearLayout);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(green.isChecked()) {
                    linearLayout.setBackgroundColor(Color.GREEN);
                } else if(red.isChecked()) {
                    linearLayout.setBackgroundColor(Color.RED);
                } else if(yellow.isChecked()) {
                    linearLayout.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        toggleButton = findViewById(R.id.toggleButton);
        imageView = findViewById(R.id.imageView);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                     imageView.setVisibility(View.INVISIBLE);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });

        spinner = findViewById(R.id.spinnerCountry);
        spinnerResult = findViewById(R.id.textViewResult);

        adapter = ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                spinnerResult.setText(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}