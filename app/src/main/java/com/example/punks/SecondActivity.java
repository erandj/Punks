package com.example.punks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    ImageButton btn_back;
    int countprogressBarTimer = 0;
    ProgressBar progressBarTimer;
    TextView textTimer;
    private String selectTopic;
    Button btn_agree;
    Button btn_denied;
    Button btn_ok;

    TextView mTextViewYkt;
    TextView mTextViewRus;

    private boolean otvet;
    public static ArrayList<Boolean> otvets;
    public static ArrayList<Boolean> answers;

    public static String randomNameYkt;
    public static String randomNameRus;
    public static int randomIndexYkt;
    public static int randomIndexRus;

    public static int[] yktslovo = {
        R.string.slovo1,
                R.string.slovo2,
                R.string.slovo3,
                R.string.slovo4,
                R.string.slovo5,
                R.string.slovo6,
                R.string.slovo7,
                R.string.slovo8,
                R.string.slovo9,
                R.string.slovo10,
                R.string.slovo11,

    };

    public static int[] russlovo = {
            R.string.russlovo1,
            R.string.russlovo2,
            R.string.russlovo3,
            R.string.russlovo4,
            R.string.russlovo5,
            R.string.russlovo6,
            R.string.russlovo7,
            R.string.russlovo8,
            R.string.russlovo9,
            R.string.russlovo10,
            R.string.russlovo11,


    };

    private AppCompatTextView option1, option2;

    private final List<SlovaList> slovaList = new ArrayList<>();

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();

        btn_agree = findViewById(R.id.btn_agree);
        btn_denied = findViewById(R.id.btn_denied);
        btn_ok = findViewById(R.id.btn_ok);

        mTextViewYkt = findViewById(R.id.textYkt);
        mTextViewRus = findViewById(R.id.textRus);

        otvets = new ArrayList<>();
        answers = new ArrayList<>();


        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);

                countDownTimer.cancel();

            }

        });

        countDownTimer = new CountDownTimer(10000, 1000)

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

        newWord();
    }

    private void newWord(){
        randomIndexYkt = new Random().nextInt(yktslovo.length);
        randomNameYkt = getResources().getString(yktslovo[randomIndexYkt]);
        mTextViewYkt.setText(randomNameYkt);

        randomIndexRus = new Random().nextInt(yktslovo.length);
        randomNameRus = getResources().getString(russlovo[randomIndexRus]);
        mTextViewRus.setText(randomNameRus);

        Boolean a = randomIndexYkt == randomIndexRus;
        answers.add(a);
    }

    public void onClickAgree(View view){
        btn_ok.setBackgroundTintList(ContextCompat.getColorStateList(SecondActivity.this, R.color.maincolor));
        otvet = true;
    }

    public void onClickDenied(View view){
        btn_ok.setBackgroundTintList(ContextCompat.getColorStateList(SecondActivity.this, R.color.maincolor));
        otvet = false;
    }

    public void onClickCall(View view){
        btn_ok.setBackgroundTintList(ContextCompat.getColorStateList(SecondActivity.this, R.color.EFEFEF));;
        otvets.add(otvet);
        newWord();
    }
}