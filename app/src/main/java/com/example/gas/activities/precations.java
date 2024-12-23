package com.example.gas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gas.R;

public class precations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precations);


        //home button
        ImageButton myButton=findViewById(R.id.home_btn);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(precations.this,home.class);
                startActivity(intent);
            }
        });

        //video button
        Button VideoButton = findViewById(R.id.video_btn2);
        VideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(precations.this,preVideo.class);
                startActivity(intent);
            }
        });

        //Temperature button
        Button TempButton = findViewById(R.id.temp_btn2);
        TempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(precations.this,TemperatureActivity.class);
                startActivity(intent);
            }
        });


    }
}