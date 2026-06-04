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
