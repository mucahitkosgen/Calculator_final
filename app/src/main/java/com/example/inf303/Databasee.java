package com.example.inf303;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class Databasee extends SQLiteOpenHelper {
    private static final String TAG = "Databasee";
    private static final String TABLE_NAMEE = "ayarlar_tablosu.db";

    private static final String COL1 = "NAMESURNAME";
    private static final String COL2 = "HEIGHT";
    private static final String COL3 = "WEIGHT";

    private static final int veritabani_versiyon = 1;
//

    public Databasee(Context context) {
        super(context, TABLE_NAMEE, null, veritabani_versiyon);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table user(namesurname text  , boy text,kilo text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public boolean insert(String namesurname, String boy, String kilo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAMESURNAME", namesurname);
        contentValues.put("HEIGHT", boy);
        contentValues.put("WEIGHT", kilo);

        Log.d(TAG, "addData:Adding " + namesurname + boy + kilo + "to" + TABLE_NAMEE);
        long result = db.insert("user", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }


}