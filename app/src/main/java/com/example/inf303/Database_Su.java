package com.example.inf303;

import android.content.ContentValues;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Database_Su extends SQLiteOpenHelper {
    private static final String TAG = "Database";
    private static final String TABLE_NAME = "su_ekle";
    private static final String COL1 = "id";
    private static final String COL2 = "ml";
    private static final String COL3 = "gun";

    // private static final String COL3="SURNAME";
    private static final int veritabani_versiyon = 1;
    int i;


    public Database_Su(Context context) {
        super(context, TABLE_NAME, null, veritabani_versiyon);
        Log.d("Hello1", "Fuck1");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table IF NOT EXISTS su_ekle " + "(id INTEGER primary key autoincrement , ml INT,gun INT unique )"
        );

        Log.d("Hello", "fuck");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public int toplam(int ml) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT ml FROM su_ekle WHERE gun=" + getDateTime(), null);
        data.moveToFirst();
        int dataInt = data.getInt(0);
        System.out.println(+dataInt);
        ml = ml + dataInt;
        update(ml);
        return ml;
    }




       /* if (data==null){
            addData(ml);
            return ml;
        }else{
           ml=ml+dataInt;
           update(ml);
           return ml;
*/


    public boolean addData(int ml) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("gun", getDateTime());
        contentValues.put("ml", ml);
        //contentValues.put("SURNAME", surname);

        Log.d(TAG, "addData:Adding " + ml + "to" + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }


    public void update(int ml) {//kayit güncelle metodu

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ml", ml);


        db.update("su_ekle", contentValues, "gun=" + getDateTime(), null);


    }


    public int getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT ml FROM su_ekle WHERE gun=" + getDateTime(), null);
        if (data.getCount() != 0) {
            data.moveToFirst();
            return data.getInt(0);
        } else {
            addData(0);

            return 0;
        }
    }


    public int getDateTime() {

        Calendar c = Calendar.getInstance();

        int date = c.get(Calendar.DAY_OF_YEAR);
        System.out.println("" + date);
        return date;
    }


}
