package com.techmania.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView score, life, time, question;
    EditText answer;
    Button ok, next;

    Random random = new Random();
    String mode;
    int number1, number2;
    int userAnswer, realAnswer;
    int userScore = 0;
    int userLife = 3;
    private Boolean isAnswered = false;

    CountDownTimer timer;
    private static final long START_TIMER_IN_MILIS = 21000;
    Boolean timer_running;
    long time_left_in_milis = START_TIMER_IN_MILIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = findViewById(R.id.textViewScore);
        life = findViewById(R.id.textViewLife);
        time = findViewById(R.id.textViewTime);
        question = findViewById(R.id.textViewQuestion);
        answer = findViewById(R.id.editTextAnswer);
        ok = findViewById(R.id.buttonOk);
        next = findViewById(R.id.buttonNext);
        mode = getIntent().getStringExtra("mode");
        getSupportActionBar().setTitle(mode.toUpperCase());

        gameContinue();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = answer.getText().toString().trim();
                if(!isAnswered) {
                    if (!TextUtils.isEmpty(inputText)) {
                        userAnswer = Integer.valueOf(answer.getText().toString());
                        pauseTimer();
                        isAnswered = true;
                        answer.setEnabled(false);
                        if (userAnswer == realAnswer) {
                            userScore += 10;
                            score.setText("" + userScore);
                            question.setText("CORRECT!");
                        } else {
                            userLife -= 1;
                            life.setText("" + userLife);
                            question.setText("WRONG ANSWER ><");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Please enter your answer or click NEXT QUESTION button.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText("");
                pauseTimer();
                resetTimer();
                answer.setEnabled(true);
                isAnswered = false;
                if(userLife == 0) {
                    Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(GameActivity.this,ResultActivity.class);
                    intent.putExtra("score",userScore);
                    startActivity(intent);
                    finish();
                } else {
                    gameContinue();
                }
            }
        });
    }

    public void gameContinue() {
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);
        if(mode.equals("addition")) {
            question.setText(number1 + " + " + number2);
            realAnswer = number1 + number2;
        } else if(mode.equals("subtraction")) {
            if(number1 >= number2) {
                question.setText(number1 + " - " + number2);
                realAnswer = number1 - number2;
            } else {
                question.setText(number2 + " - " + number1);
                realAnswer = number2 - number1;
            }

        } else if(mode.equals("multiplication")) {
            question.setText(number1 + " * " + number2);
            realAnswer = number1 * number2;
        }
        startTimer();
    }

    public void startTimer() {
        timer = new CountDownTimer(time_left_in_milis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_left_in_milis = millisUntilFinished;
                updateText();
            }

            @Override
            public void onFinish() {
                timer_running = false;
                pauseTimer();
                resetTimer();
                updateText();
                userLife -= 1;
                life.setText(""+userLife);
                question.setText("TIME'S UP");
            }
        }.start();

        timer_running = true;
    }

    public void updateText() {
        int second = (int) ((time_left_in_milis / 1000) % 60);
        String time_left = String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);
    }

    public void pauseTimer() {
        timer.cancel();
        timer_running = false;
    }

    public void resetTimer() {
        time_left_in_milis = START_TIMER_IN_MILIS;
        updateText();
    }
}