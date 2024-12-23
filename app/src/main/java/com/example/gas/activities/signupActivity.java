package com.example.gas.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gas.Database.DatabaseHelper;
import com.example.gas.databinding.ActivitySignupBinding;

public class signupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        //sign up

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.signupEmail.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirmpassword = binding.signupConfirmpassword.getText().toString();

                if (email.equals("") || password.equals("") || confirmpassword.equals(""))
                    Toast.makeText(signupActivity.this, "All fields are mandatory",
                            Toast.LENGTH_SHORT).show();
                else{
                    if (password.equals(confirmpassword)){
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (checkUserEmail == false){
                            Boolean insert = databaseHelper.insertData(email,password);

                            if (insert == true){
                                Toast.makeText(signupActivity.this,
                                        "Signup Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),
                                        LogingActivity.class);startActivity(intent);
                            }else {
                                Toast.makeText(signupActivity.this, "Signup Failed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(signupActivity.this,
                                    "User already exists, Please login",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(signupActivity.this,
                                "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //after sign up navigation

        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LogingActivity.class);
                startActivity(intent);

            }
        });


    }
}