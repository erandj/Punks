package com.example.punks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SlovaResult extends AppCompatActivity {

    private ArrayList<Boolean> gettedOtvet;
    int points;
    private TextView text;
    Button btn_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slova_result);
        gettedOtvet = SecondActivity.otvets;

        for (int i=0; i<SecondActivity.answers.size()-1; i++){
            if (SecondActivity.answers.get(i) == SecondActivity.otvets.get(i)){
                points += 15;
            }
        }

        text = findViewById(R.id.textScore);
        text.setText(Integer.toString(points));

        btn_Back = findViewById(R.id.btnBack);

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SlovaResult.this, FirstActivity.class);
                startActivity(intent);

            }

        });
    }
}