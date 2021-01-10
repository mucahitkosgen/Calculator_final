package com.example.inf303;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class Database2 extends SQLiteOpenHelper {
    private static final String TAG = "Database2";
    private static final String TABLE_NAME2 = "kullanici_tablosu.db";

    private static final String COL1 = "MAIL";
    private static final String COL2 = "SIFRE";


    private static final int veritabani_versiyon = 1;


    public Database2(Context context) {
        super(context, TABLE_NAME2, null, veritabani_versiyon);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Wir haben eine Datenbanktabelle mit diesem Code erstellt
        db.execSQL(
                "create table user(mail text primary key , sifre text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);


    }


    public boolean insert(String mail, String sifre) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MAIL", mail);
        contentValues.put("SIFRE", sifre);
        //Anzeigen der mit log.d aufgezeichneten Daten
        Log.d(TAG, "addData:Adding " + mail + sifre + "to" + TABLE_NAME2);
        long result = db.insert("user", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public boolean chkmail(String mail) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where mail=?", new String[]{mail});
        if (cursor.getCount() > 0)
            return false;
        else
            return true;
    }

    public boolean emailpassword(String mail, String sifre) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where mail=? and sifre=?", new String[]{mail, sifre});
        if (cursor.getCount() > 0) {
            return true;
        } else
            return false;
    }

}
