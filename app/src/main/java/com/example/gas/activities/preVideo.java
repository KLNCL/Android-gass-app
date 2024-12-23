package com.example.gas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.gas.R;

public class preVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_video);

        // Video player
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+ "/"+R.raw.gasvideo);
        videoView.pause();

        MediaController MediaController = new MediaController(this);
        MediaController.setAnchorView(videoView);
        videoView.setMediaController(MediaController);


    }
}