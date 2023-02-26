package com.example.iotdash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView Login_text,signup_text;
    EditText User_edit, Password_edit;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login_text = findViewById(R.id.Login);
        signup_text = findViewById(R.id.tv2);
        User_edit = findViewById(R.id.username);
        Password_edit = findViewById(R.id.password);
        Login = findViewById(R.id.button);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = User_edit.getText().toString();
                String password = Password_edit.getText().toString();

                if (username.equals("admin") || Patterns.EMAIL_ADDRESS.matcher(username).matches() && username.equals("2015053@nec.edu.in")) {
                             if (password.equals("12345") ) {
                                 Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_LONG).show();
                                 startActivity(new Intent(MainActivity.this, new1.class));
                             }
                            else {
                        Toast.makeText(MainActivity.this, "Password is Incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(!(Patterns.EMAIL_ADDRESS.matcher(username).matches())){
                    Toast.makeText(MainActivity.this, "Enter the valid email id", Toast.LENGTH_SHORT).show();
                }
                else if (username.isEmpty()) {
                    if (password.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Enter the username and password", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Enter the username", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (password.isEmpty()) {
                    if (username.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Enter the username and password", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Enter the password", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "already you are in the login page", Toast.LENGTH_SHORT).show();
            }
        });
        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Signup page", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,new3.class));
            }
        });
    }
}