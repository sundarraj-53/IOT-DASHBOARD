package com.example.iotdash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class new3 extends AppCompatActivity {

    TextView signup_text,Login_text;
    EditText User_edit,Email_edit,Password_edit,CPassword_Edit;
    Button Signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new3);
        signup_text=findViewById(R.id.sign);
        Login_text=findViewById(R.id.Login);
        User_edit=findViewById(R.id.username);
        Email_edit=findViewById(R.id.email);
        Password_edit=findViewById(R.id.password);
        CPassword_Edit=findViewById(R.id.c_password);
        Signup=findViewById(R.id.sign_up_button);

        Login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(new3.this,MainActivity.class));
                Toast.makeText(new3.this, "Login page", Toast.LENGTH_SHORT).show();
            }
        });

    }
}