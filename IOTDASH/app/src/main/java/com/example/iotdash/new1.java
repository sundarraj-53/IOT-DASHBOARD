package com.example.iotdash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iotdash.R.id;

public class new1 extends AppCompatActivity {

    private TextView h3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);

        h3 = findViewById(R.id.t3);
        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  startActivity(new Intent(new1.this,new3.class));
                Toast.makeText(new1.this,"New page",Toast.LENGTH_LONG).show();
            }
        });


    }
}