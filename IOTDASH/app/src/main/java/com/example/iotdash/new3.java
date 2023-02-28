package com.example.iotdash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iotdash.databinding.ActivityNew3Binding;

public class new3 extends AppCompatActivity {

    ActivityNew3Binding binding;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNew3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db= new DBHandler(this);


        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = binding.username.getText().toString();
                String Email = binding.email.getText().toString();
                String Password = binding.password.getText().toString();
                String Cpassword = binding.cPassword.getText().toString();

                if (Username.isEmpty() && Email.isEmpty() && Password.isEmpty() && Cpassword.isEmpty()) {
                    Toast.makeText(new3.this, "Enter the Signup creditals", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Password.equals(Cpassword)) {
                    Toast.makeText(new3.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                    Toast.makeText(new3.this, "Enter the Valid Email Address", Toast.LENGTH_SHORT).show();
                }
                if (Password.length() > 15) {
                    Toast.makeText(new3.this, "Password size is Not greater than 10", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    if (Password.equals(Cpassword)) {
                        Boolean checkUserEmail = db.checkEmail(Username,Email);
//                        Email


                        if (checkUserEmail == false) {
                            Boolean insert = db.insertData(Username,Email,Password,Cpassword);
//                            Email,
                            if (insert == true) {
                                Toast.makeText(new3.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(new3.this, MainActivity.class));
                            } else {
                                Toast.makeText(new3.this, "Sign up Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(new3.this, "User already existed please login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(new3.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(new3.this,MainActivity.class));
                Toast.makeText(new3.this, "Login page", Toast.LENGTH_SHORT).show();
            }
        });

    }
}