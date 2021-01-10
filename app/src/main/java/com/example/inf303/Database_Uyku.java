package com.example.inf303;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

public class Database_Uyku extends SQLiteOpenHelper implements TimePickerDialog.OnTimeSetListener {


    private static final String TAG = "Database";

    private static final String TABLE_NAME = "uyku_data";
    private static final String COL1 = "ID";
    private static final String COL2 = "SAAT";
    private static final String COL3 = "DAKIKA";
    private static final String COL4 = "GUN";

    public Database_Uyku(Context context) {

        super(context, TABLE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , SAAT INTEGER, DAKIKA INTEGER, GUN INTEGER )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addData(int hourOfDay, int minute) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery("SELECT SAAT FROM uyku_data WHERE GUN=" + getDateTime(), null);
        Cursor data2 = db.rawQuery("SELECT DAKIKA FROM uyku_data WHERE GUN=" + getDateTime(), null);
        if (data.getCount() != 0) {
            data.moveToFirst();
            ContentValues contentValues = new ContentValues();

            contentValues.put("SAAT", hourOfDay);
            contentValues.put("DAKIKA", minute);

            db.update("uyku_data", contentValues, "GUN=" + getDateTime(), null);

            Log.d(TAG, "addData: Adding " + hourOfDay + " to " + TABLE_NAME);
            Log.d(TAG, "addData: Adding " + minute + " to " + TABLE_NAME);
            long result = db.update(TABLE_NAME, contentValues, "GUN=" + getDateTime(), null);
            return result != -1;

        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("GUN", getDateTime());
            contentValues.put("SAAT", hourOfDay);
            contentValues.put("DAKIKA", minute);

            Log.d(TAG, "addData: Adding " + hourOfDay + " to " + TABLE_NAME);
            Log.d(TAG, "addData: Adding " + minute + " to " + TABLE_NAME);
            long result = db.insert(TABLE_NAME, null, contentValues);
            return result != -1;
        }

    }


    public int getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT SAAT FROM uyku_data WHERE GUN=" + getDateTime(), null);

        if (data.getCount() != 0) {
            data.moveToFirst();
            System.out.println("get data calisiyor");
            return data.getInt(0);
        } else {
            return 0;
        }
    }

    public int getData2() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT DAKIKA FROM uyku_data WHERE GUN=" + getDateTime(), null);

        if (data.getCount() != 0) {
            data.moveToFirst();
            System.out.println("get data2 calisiyor");
            return data.getInt(0);
        } else {
            return 0;
        }

    }


    public int getDateTime() {

        Calendar c = Calendar.getInstance();

        int date = c.get(Calendar.DAY_OF_YEAR);
        System.out.println("" + date);
        return date;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
}

