package com.example.gas.activities;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AmbientTemperatureManager implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor temperatureSensor;
    private OnTemperatureChangeListener temperatureChangeListener;

    public AmbientTemperatureManager(Context context) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        }
    }

    public void setTemperatureChangeListener(OnTemperatureChangeListener listener) {
        temperatureChangeListener = listener;
    }

    public void start() {
        if (sensorManager != null && temperatureSensor != null) {
            sensorManager.registerListener(this, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void stop() {
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not used in this example
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            float temperature = event.values[0];
            if (temperatureChangeListener != null) {
                temperatureChangeListener.onTemperatureChanged(temperature);
            }
        }
    }

    public interface OnTemperatureChangeListener {
        void onTemperatureChanged(float temperature);
    }
}


