package com.techmania.userinteractions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button showToast, showSnackbar, showDialog;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast = findViewById(R.id.buttonShowToast);
        showSnackbar = findViewById(R.id.buttonShowSnackbar);
        showDialog = findViewById(R.id.buttonShowDialog);

        linearLayout = findViewById(R.id.linear);

        showToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"This is a Toast Message.",Toast.LENGTH_SHORT).show();
            }
        });

        showSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(linearLayout,"This is a Snackbar Message.",Snackbar.LENGTH_INDEFINITE)
                        .setAction("Close", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Delete")
                        .setMessage("Do you want to change the text of the button?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showDialog.setText("Alert Dialog");
                            }
                        })
                        .show();
                alertDialog.create();
            }
        });
    }
}