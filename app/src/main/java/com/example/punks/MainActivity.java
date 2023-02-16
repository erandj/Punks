package com.example.punks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView tv;
    ProgressBar progressBar;
    AppCompatButton btnStartTimer;
    int countprogressBar = 0;



   @Override
   public void onCreate(Bundle savedInstanceState)
   {

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       progressBar = findViewById(R.id.progressBar);



       CountDownTimer countDownTimer = new CountDownTimer(5000, 1000)
       {
           @Override
           public void onTick(long l) {
               countprogressBar++;
               progressBar.setMax(5);
               progressBar.setProgress((int) l/1000);

               tv.setText(String.valueOf(l/1000));


           }
           @Override
           public void onFinish() {
                   Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                   startActivity(intent);

           }
       };

       tv = findViewById(R.id.textSeconds);
       btnStartTimer = findViewById(R.id.btnStartTimer);
       btnStartTimer.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               countDownTimer.start();
               btnStartTimer.setVisibility(View.INVISIBLE);
           }
       });






   }


}