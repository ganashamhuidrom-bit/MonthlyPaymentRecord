package com.example.monthlypayment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity
        extends AppCompatActivity {

    Button btnAdd;

    ListView listCustomers;

    DatabaseHelper db;

    ArrayList<String> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnAdd =
            findViewById(R.id.btnAdd);

        listCustomers =
            findViewById(R.id.listCustomers);

        db = new DatabaseHelper(this);

        btnAdd.setOnClickListener(v -> {

            Intent intent =
                new Intent(
                    MainActivity.this,
                    AddCustomerActivity.class
                );

            startActivity(intent);
        });

        loadCustomers();
    }

    private void loadCustomers() {

        customers = new ArrayList<>();

        Cursor c = db.getCustomers();

        while(c.moveToNext()) {

            String data =
                c.getString(1)
                + "\nPhone: "
                + c.getString(2)
                + "\nBalance: ₹"
                + c.getDouble(3);

            customers.add(data);
        }

        ArrayAdapter<String> adapter =
            new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                customers
            );

        listCustomers.setAdapter(adapter);
    }

    @Override
    protected void onResume() {

        super.onResume();

        loadCustomers();
    }
        }
