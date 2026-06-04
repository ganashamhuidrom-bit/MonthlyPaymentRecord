package com.example.monthlypayment;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PaymentHistoryActivity
        extends AppCompatActivity {

    ListView listPayments;

    DatabaseHelper db;

    ArrayList<String> payments;

    int customerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(
            R.layout.activity_payment_history);

        listPayments =
            findViewById(R.id.listPayments);

        db = new DatabaseHelper(this);

        customerId =
            getIntent().getIntExtra(
                "customer_id",
                0
            );

        loadPayments();
    }

    private void loadPayments() {

        payments = new ArrayList<>();

        Cursor c =
            db.getPaymentsByCustomer(
                customerId
            );

        while(c.moveToNext()) {

            String data =
                "Receipt: "
                + c.getString(3)
                + "\nAmount: ₹"
                + c.getDouble(2)
                + "\nDate: "
                + c.getString(4);

            payments.add(data);
        }

        ArrayAdapter<String> adapter =
            new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                payments
            );

        listPayments.setAdapter(adapter);
    }
        }
