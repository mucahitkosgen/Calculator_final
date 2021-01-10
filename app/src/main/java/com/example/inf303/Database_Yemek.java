package com.example.inf303;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.example.inf303.Yemek;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Database_Yemek extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "yemek.db"; 
    public static final String TABLE_NAME = "Yemek_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "TYPE";
    public static final String COL_4 = "KALORI";
    public static final String DATABASE_NAME2 = "yemek.db";
    public static final String TABLE_NAME2 = "Yemeklerim_table";
    public static final String COL1 = "ID";
    public static final String COL2 = "KAL";
    public static final String COL3 = "gun";


    public Database_Yemek(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,TYPE TEXT,KALORI INTEGER)");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Kuru fasulye','yemek','336')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Pirinç Pilavı','yemek','363')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('1 Dilim Beyaz Ekmek','yemek','90')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('1 Dilim Kepek Ekmek','yemek','60')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Kuravasan','yemek','200')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Makarna','yemek','339')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Mercimek','yemek','314')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Süt','içecek','61')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Ayran','içecek','37')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Beyaz Peynir','yemek','260')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Parmesan Peyniri','yemek','440')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Krem Peynir','yemek','349')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Tereyağı','yemek','750')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Dana Bonfile','yemek','137')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Biftek','yemek','156')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Kuzu Eti','yemek','310')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Tavuk','yemek','215')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Tavuk But','yemek','232')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Hamsi','yemek','131')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Levrek Fileto','yemek','98')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Lüfer Fileto','yemek','124')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Midye','yemek','9')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Ton Balığı','yemek','121')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Big Mac','yemek','590')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Kentucky Tavuk','yemek','450')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Pizza(Peynirli)','yemek','264')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Kola','içecek','164')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Espresso','içecek','41')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Bal','yemek','315')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Dondurma','yemek','193')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Çikolata(Sütlü)','yemek','528')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Şeker(1 Kesme))','yemek','25')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Patates Cips','yemek','570')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Limon','yemek','27')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Pırasa','yemek','52')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Ispanak','yemek','26')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Patates Kızartma','yemek','280')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Patates Haşlama','yemek','76')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Bezelye','yemek','89')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Soğan','yemek','38')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Maydonoz(10 Sap)','yemek','44')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Somon Füme','yemek','171')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Türlü','yemek','223')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Yoğurt','yemek','59')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Salatalık','sebze','15')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Patlıcan','sebze','24')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Brokoli','sebze','40')");
        db.execSQL("INSERT INTO  Yemek_table(NAME,TYPE,KALORI) VALUES ('Domates','sebze','14')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (NAME,TYPE,KALORI) VALUES ('Nohut','yemek','364')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (NAME,TYPE,KALORI) VALUES ('Elma','meyve','52')");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (NAME,TYPE,KALORI) VALUES ('Marul','sebze','18')");
        db.execSQL("create table IF NOT EXISTS " + TABLE_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,KALORI INTEGER,gun INTEGER)");
        Cursor cursor2 = db.rawQuery("SELECT * FROM Yemeklerim_table", null);
        Cursor cursor = db.rawQuery("SELECT * FROM  Yemek_table", null);
        int nameX = cursor.getColumnIndex("NAME");
        int typeX = cursor.getColumnIndex("TYPE");
        int kaloriX = cursor.getColumnIndex("KALORI");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

         /*public boolean insertData(String name,String type , String kalori) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues() ;
            contentValues.put("NAME",name);
            contentValues.put("TYPE",type);
            contentValues.put("KALORI",kalori);
            long result = db.insert(TABLE_NAME,null,contentValues) ;
            if(result == -1) {
                return  false ;
            }else{
                return  true;
            }



        } */

    public List<Yemek> getYemek() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"ID", "NAME", "TYPE", "KALORI"};
        String tableName = "Yemek_table";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Yemek> result = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {

                Yemek yemek = new Yemek();
                yemek.setID(cursor.getInt(cursor.getColumnIndex("ID")));
                yemek.setNAME(cursor.getString(cursor.getColumnIndex("NAME")));
                yemek.setTYPE(cursor.getString(cursor.getColumnIndex("TYPE")));
                yemek.setKALORI(cursor.getInt(cursor.getColumnIndex("KALORI")));
                result.add(yemek);

            } while (cursor.moveToNext());


        }
        return result;

    }

    public List<String> getNames() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"NAME"};
        String tableName = "Yemek_table";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {

                result.add(cursor.getString(cursor.getColumnIndex("NAME")));

            } while (cursor.moveToNext());


        }
        return result;

    }

    public List<Yemek> getYemekByName(String NAME) {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"ID", "NAME", "TYPE", "KALORI"};
        String tableName = "Yemek_table";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "NAME LIKE ?", new String[]{"%" + NAME + "%"}, null, null, null);
        List<Yemek> result = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {

                Yemek yemek = new Yemek();
                yemek.setID(cursor.getInt(cursor.getColumnIndex("ID")));
                yemek.setNAME(cursor.getString(cursor.getColumnIndex("NAME")));
                yemek.setTYPE(cursor.getString(cursor.getColumnIndex("TYPE")));
                yemek.setKALORI(cursor.getInt(cursor.getColumnIndex("KALORI")));
                result.add(yemek);

            } while (cursor.moveToNext());


        }
        return result;

    }

    public void getData(String choosen) { // Kalorien von gesuchte Lebensmittel

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT KALORI FROM Yemek_table WHERE NAME=" + "'" + choosen + "'", null);
        System.out.println("buraya geldim");
        if (data.getCount() != 0) {
            data.moveToFirst();

        }
        System.out.println("burayada geldim" + data.getInt(0));
        addData2(data.getInt(0));


    }

    public int getData2() { // Für zweite Table(Yemeklerim_table)

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT KALORI FROM Yemeklerim_table WHERE gun=" + "'" + getDateTime() + "'", null);
        System.out.println("buraya geldim");
        if (data.getCount() != 0) {
            data.moveToFirst();
            return data.getInt(0);
        } else {
            return 0;
        }
    }


    public void addData2(int KALORI) { //Kalori hinzugefügt Table 2(Yemeklerim_table)

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT KALORI FROM Yemeklerim_table WHERE gun=" + getDateTime(), null);
        if (data.getCount() != 0) {


            data.moveToFirst();
            int dataInt = data.getInt(0);

            System.out.println(+dataInt);
            KALORI = KALORI + dataInt;
            update(KALORI);
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gun", getDateTime());
            contentValues.put("KALORI", KALORI);


            Log.d(TAG, "addData:Adding " + KALORI + "to" + TABLE_NAME2);
            long result = db.insert(TABLE_NAME2, null, contentValues);



                   /* Cursor cursor = db.rawQuery("INSERT INTO Yemeklerim_table(KALORI,gun) VALUES("+KALORI "," +getDateTime(),null);
                    ContentValues contentValues=new ContentValues();
                    contentValues.put("gun",getDateTime());
                    contentValues.put("KALORI", KALORI);
                    return KALORI;*/
        }

    }


    public void update(int KALORI) {// data update function, neue kalorie hinzufügen

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("KALORI", KALORI);


        db.update("Yemeklerim_table", contentValues, "gun=" + getDateTime(), null);
    }


    public int getDateTime() {// neue Spalte herstellt für jdn Tag

        Calendar c = Calendar.getInstance();

        int date = c.get(Calendar.DAY_OF_YEAR);
        System.out.println("" + date);
        return date;
    }

}


