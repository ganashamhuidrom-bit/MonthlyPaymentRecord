package com.example.monthlypayment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {

        super(context, "payments.db", null, 1);
    }
@Override
public void onCreate(SQLiteDatabase db) {

    db.execSQL(
        "CREATE TABLE customers(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "name TEXT," +
        "phone TEXT," +
        "balance REAL)"
    );

    db.execSQL(
        "CREATE TABLE payments(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "customer_id INTEGER," +
        "amount REAL," +
        "receipt_no TEXT," +
        "payment_date TEXT)"
    );
}
    

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

    }

    public boolean addCustomer(String name,
                               String phone,
                               double balance) {

        SQLiteDatabase db =
            this.getWritableDatabase();

        ContentValues cv =
            new ContentValues();

        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("balance", balance);

        long result =
            db.insert("customers",
            null,
            cv);

        return result != -1;
    }

    public Cursor getCustomers() {

        SQLiteDatabase db =
            this.getReadableDatabase();

        return db.rawQuery(
            "SELECT * FROM customers",
            null);
    }
}
public boolean addPayment(
        int customerId,
        double amount,
        String receiptNo,
        String paymentDate) {

    SQLiteDatabase db =
        this.getWritableDatabase();

    ContentValues cv =
        new ContentValues();

    cv.put("customer_id", customerId);
    cv.put("amount", amount);
    cv.put("receipt_no", receiptNo);
    cv.put("payment_date", paymentDate);

    long result =
        db.insert(
            "payments",
            null,
            cv);

    return result != -1;public Cursor getPaymentsByCustomer(
        int customerId) {

    SQLiteDatabase db =
        this.getReadableDatabase();

    return db.rawQuery(
        "SELECT * FROM payments " +
        "WHERE customer_id=?",
        new String[]{
            String.valueOf(customerId)
        }
    );
}
}
