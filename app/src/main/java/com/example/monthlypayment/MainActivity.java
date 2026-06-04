package com.example.monthlypayment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity
        extends AppCompatActivity {

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {

            Intent intent =
                new Intent(
                    MainActivity.this,
                    AddCustomerActivity.class
                );

            startActivity(intent);
        });
    }
        }
