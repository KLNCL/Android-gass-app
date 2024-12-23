package com.example.gas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gas.Database.DatabaseHelper;
import com.example.gas.databinding.ActivityLogingBinding;

public class LogingActivity extends AppCompatActivity {

    ActivityLogingBinding binding;
    DatabaseHelper databaseHelper;


//Login
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.logingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.logingEmail.getText().toString();
                String password = binding.logingPassword.getText().toString();

                if (email.equals("") || password.equals(""))
                    Toast.makeText(LogingActivity.this, "All fields are mandatory",
                            Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkcredentials = databaseHelper.checkEmailPassword(email, password);
                    
                    if (checkcredentials == true){
                        Toast.makeText(LogingActivity.this,
                                "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),home.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LogingActivity.this,
                                "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //after loging navigation part
        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogingActivity.this,signupActivity.class);
                startActivity(intent);
            }
        });
    }
}