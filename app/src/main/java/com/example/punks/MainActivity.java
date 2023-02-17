package com.example.punks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView tv;
    ProgressBar progressBar;
    Button btnStartTimer;
    int countprogressBar = 0;
    ImageButton btn_Back;

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
       //Эллэй крутой
       getSupportActionBar().hide();

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       progressBar = findViewById(R.id.progressBar);
       btn_Back = findViewById(R.id.btn_back3);
       tv = findViewById(R.id.textSeconds);
       btnStartTimer = findViewById(R.id.btnStartTimer);


       btn_Back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, FirstActivity.class);
               startActivity(intent);
           }
       });



       CountDownTimer countDownTimer = new CountDownTimer(5000, 1000)
       {
           @Override
           public void onTick(long l) {
               countprogressBar++;
               progressBar.setMax(5);
               progressBar.setProgress(countprogressBar);

               tv.setText(String.valueOf(l/1000));


           }
           @Override
           public void onFinish() {
                   Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                   startActivity(intent);

           }
       };


       btnStartTimer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               countDownTimer.start();
               btnStartTimer.setVisibility(View.INVISIBLE);
           }
       });








   }


}