package com.example.monthlypayment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCustomerActivity
        extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etBalance;

    Button btnSave;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(
            R.layout.activity_add_customer);

        db = new DatabaseHelper(this);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etBalance = findViewById(R.id.etBalance);

        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {

            String name =
                etName.getText().toString();

            String phone =
                etPhone.getText().toString();

            double balance =
                Double.parseDouble(
                etBalance.getText().toString());

            boolean result =
                db.addCustomer(
                name,
                phone,
                balance);

            if(result) {

                Toast.makeText(
                    this,
                    "Customer Saved",
                    Toast.LENGTH_SHORT
                ).show();

                finish();
            }
        });
    }
        }
