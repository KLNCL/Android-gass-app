package com.example.gas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gas.R;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //order button
        Button orderButton=findViewById(R.id.order_btn);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,order.class);
                startActivity(intent);
            }
        });

        //types of gas button
        Button typeButton=findViewById(R.id.types_btn);
        typeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,types_of_gas.class);
                startActivity(intent);
            }
        });

        //precations button
        Button precationButton=findViewById(R.id.precations_btn);
        precationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,precations.class);
                startActivity(intent);
            }
        });

        //map button
        Button mapButton=findViewById(R.id.map_btn);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,Maps.class);
                startActivity(intent);
            }
        });

        //gas stores button
        Button storeButton=findViewById(R.id.store_btn);
        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,gas_stores.class);
                startActivity(intent);
            }
        });

        //gas stores button
        Button LogOutButton=findViewById(R.id.logout_btn);
        LogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,LogingActivity.class);
                startActivity(intent);
            }
        });

        //gas stores button
        Button OrdeNowButton=findViewById(R.id.order_btn);
        OrdeNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,order.class);
                startActivity(intent);
            }
        });


    }
}