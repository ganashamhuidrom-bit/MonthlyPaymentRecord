package com.example.monthlypayment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity
        extends AppCompatActivity {

    TextView tvReceipt;

    EditText etAmount;

    Button btnSavePayment;

    String receiptNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(
            R.layout.activity_payment);

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

            String amount =
                etAmount.getText().toString();

            Toast.makeText(
                this,
                "Payment Saved",
                Toast.LENGTH_SHORT
            ).show();
        });
    }
        }
