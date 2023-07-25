package com.techmania.componentsinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button,display;

    EditText name;
    Button ok;
    TextView result;
    String userName;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textExample);
        button = findViewById(R.id.doMagic);
        display = findViewById(R.id.buttonDisplay);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setBackgroundColor(Color.BLACK);
                text.setText("I have done my magic.");
                text.setVisibility(View.INVISIBLE);
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.BLACK);
                text.setBackgroundColor(Color.YELLOW);
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setVisibility(View.VISIBLE);
            }
        });

        name = findViewById(R.id.editTextName);
        ok = findViewById(R.id.buttonOk);
        result = findViewById(R.id.result);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = name.getText().toString();
                result.setText(userName);
            }
        });

        image = findViewById(R.id.imageView);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.pic2);
            }
        });
    }
}