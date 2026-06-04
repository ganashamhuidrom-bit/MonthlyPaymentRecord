package com.example.monthlypayment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PaymentActivity
        extends AppCompatActivity {

    TextView tvReceipt;

    EditText etAmount;

    Button btnSavePayment;

    String receiptNo;

    DatabaseHelper db;

    int customerId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(
            R.layout.activity_payment);

        db = new DatabaseHelper(this);

        tvReceipt =
            findViewById(R.id.tvReceipt);

        etAmount =
            findViewById(R.id.etAmount);

        btnSavePayment =
            findViewById(R.id.btnSavePayment);

        receiptNo =
            "RCPT" +
            System.currentTimeMillis();

        tvReceipt.setText(
            "Receipt No: " + receiptNo);

        btnSavePayment
            .setOnClickListener(v -> {

            String amountText =
                etAmount.getText().toString();

            if(amountText.isEmpty()) {

                Toast.makeText(
                    this,
                    "Enter Amount",
                    Toast.LENGTH_SHORT
                ).show();

                return;
            }

            double amount =
                Double.parseDouble(amountText);

            String paymentDate =
                new SimpleDateFormat(
                    "dd/MM/yyyy",
                    Locale.getDefault()
                ).format(new Date());

            boolean result =
                db.addPayment(
                    customerId,
                    amount,
                    receiptNo,
                    paymentDate
                );

            if(result) {

                Toast.makeText(
                    this,
                    "Payment Saved",
                    Toast.LENGTH_SHORT
                ).show();

                finish();

            } else {

                Toast.makeText(
                    this,
                    "Failed",
                    Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
        }
