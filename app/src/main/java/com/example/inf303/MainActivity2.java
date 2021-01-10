package com.example.inf303;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static String TAG = "MainActivity2";
    Database2 db;
    Profil v4;
    Hedef_kalori v5;
    private ImageButton kayit, giris;
    private EditText kullanici_adi;
    private TextView kayit_text, giris_text;
    private EditText sifre, sifre_tekrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        kayit_text = (TextView) findViewById(R.id.kayit_text);
        giris_text = (TextView) findViewById(R.id.giris_text);
        kullanici_adi = (EditText) findViewById(R.id.kullanici_adi);
        sifre = (EditText) findViewById(R.id.sifre);
        sifre_tekrar = (EditText) findViewById(R.id.sifre_tekrar);
        kayit = (ImageButton) findViewById(R.id.kayit);
        giris = (ImageButton) findViewById(R.id.giris);


        db = new Database2(this);
        v5 = new Hedef_kalori();


        final Context context = this;

        kayit_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = kullanici_adi.getText().toString();
                String b = sifre.getText().toString();
                String c = sifre_tekrar.getText().toString();
                if (a.equals("") || b.equals("") || c.equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris, Toast.LENGTH_LONG).show();
                    return;
                } else if (b.equals(c)) {
                    Boolean chkmail = db.chkmail(a);
                    if (chkmail == true) {
                        Boolean insert = db.insert(a, b);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), R.string.Toast_giris_2, Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                            startActivity(i);
                            return;
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.Toast_giris_3, Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                Toast.makeText(getApplicationContext(), R.string.Toast_giris_4, Toast.LENGTH_LONG).show();
            }
        }
        );
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = kullanici_adi.getText().toString();
                String b = sifre.getText().toString();
                String c = sifre_tekrar.getText().toString();
                if (a.equals("") || b.equals("") || c.equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris, Toast.LENGTH_LONG).show();
                    return;
                } else if (b.equals(c)) {
                    Boolean chkmail = db.chkmail(a);
                    if (chkmail == true) {
                        Boolean insert = db.insert(a, b);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), R.string.Toast_giris_2, Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                            startActivity(i);
                            return;
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.Toast_giris_3, Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                Toast.makeText(getApplicationContext(), R.string.Toast_giris_4, Toast.LENGTH_LONG).show();
            }
        });
        giris_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = kullanici_adi.getText().toString();
                String b = sifre.getText().toString();
                String c = sifre_tekrar.getText().toString();
                Boolean Chkemailpass = db.emailpassword(a, b);
                if (Chkemailpass == true) {
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris_2, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                    startActivity(i);
                } else if (a.equals("") || b.equals("") || c.equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris, Toast.LENGTH_LONG).show();
                    return;
                } else
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris_5, Toast.LENGTH_LONG).show(); }
        });
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = kullanici_adi.getText().toString();
                String b = sifre.getText().toString();
                String c = sifre_tekrar.getText().toString();
                Boolean Chkemailpass = db.emailpassword(a, b);
                if (Chkemailpass == true) {
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris_2, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                    startActivity(i);
                } else if (a.equals("") || b.equals("") || c.equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris, Toast.LENGTH_LONG).show();
                    return;
                } else
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris_5, Toast.LENGTH_LONG).show();
            }

        });


    }
}