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

import com.example.iotdash.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//       TextView signup_text;
//    EditText User_edit, Password_edit;
//    Button Login;

    ActivityMainBinding binding;
    DBHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        Login_text = findViewById(R.id.Login);
//        signup_text = findViewById(R.id.tv2);
//        User_edit = findViewById(R.id.username);
//        Password_edit = findViewById(R.id.password);
//        Login = findViewById(R.id.button);

         db=new DBHandler(this);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.username.getText().toString();
                String email=binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if(username.isEmpty() || email.isEmpty() && password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter the User crediantals", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Boolean checkCredentials=db.checkEmailPassword(username,email,password);
//                    email
                    if(checkCredentials == true){
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,new1.class));
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }

                }
//                if (username.equals("admin") || Patterns.EMAIL_ADDRESS.matcher(username).matches() && username.equals("2015053@nec.edu.in")) {
//                             if (password.equals("12345") ) {
//                                 Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_LONG).show();
//                                 startActivity(new Intent(MainActivity.this, new1.class));
//                             }
//                            else {
//                        Toast.makeText(MainActivity.this, "Password is Incorrect", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else if(!(Patterns.EMAIL_ADDRESS.matcher(username).matches())){
//                    Toast.makeText(MainActivity.this, "Enter the valid email id", Toast.LENGTH_SHORT).show();
//                }
//                else if (username.isEmpty()) {
//                    if (password.isEmpty()) {
//                        Toast.makeText(MainActivity.this, "Enter the username and password", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(MainActivity.this, "Enter the username", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else if (password.isEmpty()) {
//                    if (username.isEmpty()) {
//                        Toast.makeText(MainActivity.this, "Enter the username and password", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(MainActivity.this, "Enter the password", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
//                }
            }
        });
//        binding.Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "already you are in the login page", Toast.LENGTH_SHORT).show();
//            }
//        });
        binding.tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Signup page", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,new3.class));
            }
        });
    }
}