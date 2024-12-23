package com.example.gas.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gas.R;

public class TemperatureActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor temperatureSensor;
    private AmbientTemperatureManager temperatureManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        // home button
        ImageButton homeButton=findViewById(R.id.home_btn5);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TemperatureActivity.this,home.class);
                startActivity(intent);
            }
        });

        //sensor part

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        }

        temperatureManager = new AmbientTemperatureManager(this);
        temperatureManager.setTemperatureChangeListener(new AmbientTemperatureManager.OnTemperatureChangeListener() {
            @Override
            public void onTemperatureChanged(float temperature) {
                updateTemperature(temperature);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (temperatureManager != null) {
            temperatureManager.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (temperatureManager != null) {
            temperatureManager.stop();
        }
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    private void updateTemperature(float temperature) {
        TextView temperatureTextView = findViewById(R.id.temperature_text_view);
        temperatureTextView.setText(getString(R.string.activity_temperature, temperature));
    }
}
