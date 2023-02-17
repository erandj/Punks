package com.example.punks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ImageButton btn_back;
    int countprogressBarTimer = 0;
    ProgressBar progressBarTimer;
    TextView textTimer;
    private String selectTopic = "";
    Button btn_agree;
    Button btn_denied;
    Button btn_ok;


    private AppCompatTextView option1, option2;

    private final List<SlovaList> slovaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();


        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);

            }

        });

        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000)

        {
            @Override
            public void onTick(long l) {
                textTimer = findViewById(R.id.textTimer);
                progressBarTimer = findViewById(R.id.progressBarTimer);
                countprogressBarTimer++;


                textTimer.setText(String.valueOf(l/1000));


            }
            @Override
            public void onFinish() {
                Toast.makeText(SecondActivity.this, "Время вышло", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondActivity.this, SlovaResult.class);
                startActivity(intent);

            }
        };
        countDownTimer.start();



        btn_agree = findViewById(R.id.btn_agree);
        btn_denied = findViewById(R.id.btn_denied);
        btn_ok = findViewById(R.id.btn_ok);


        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTopic = "verno";

            }
        });

        btn_denied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTopic = "neverno";
            }
        });


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (selectTopic.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Выберите свой ответ", Toast.LENGTH_SHORT).show();
                }


            }
        });

        private int getCorrectAnswer () {
            int correctAnswer = 0;

            for (int i = 0; i < slovaList.size(); i++) {
                final String getUserSelectedAnswer = slovaList.get(i).getUserSelectedAnswer();
                final String getAnswer = slovaList.get(i).getAnswer();

                if (getUserSelectedAnswer.equals(getAnswer)) {
                    correctAnswer++;
                }

            }
            return correctAnswer;
        }

    }
}