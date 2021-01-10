package com.example.inf303;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Yemekara_Arayuz extends AppCompatActivity {

    Database_Yemek myDb;
    public ImageView btn_yemek_ara;
    public ImageView yemek_ara_arayuz_btn_home;
    public ImageView yemek_ara_arayuz_btn_tarif;
    public ImageView yemek_ara_arayuz_btn_ayarlar;
    public TextView kalori_yazisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemekara__arayuz);
        myDb = new Database_Yemek(this);
        kalori_yazisi = findViewById(R.id.kalori_yazisi);
        yemek_ara_arayuz_btn_tarif = findViewById(R.id.yemek_ara_arayuz_btn_tarif);
        yemek_ara_arayuz_btn_ayarlar = findViewById(R.id.yemek_ara_arayuz_btn_ayarlar);
        yemek_ara_arayuz_btn_home = findViewById(R.id.yemek_ara_arayuz_btn_home);
        btn_yemek_ara = findViewById(R.id.btn_yemek_ara);
        kalori_yazisi.setText(myDb.getData2() + "");
        btn_yemek_ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent yemeksecarayuz = new Intent(Yemekara_Arayuz.this, com.example.inf303.yemeksecarayuz.class);
                startActivity(yemeksecarayuz);


            }
        });
        yemek_ara_arayuz_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                startActivity(i);
            }
        });
        yemek_ara_arayuz_btn_tarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Tarifler.class);
                startActivity(i);
            }
        });
        yemek_ara_arayuz_btn_ayarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Profil.class);
                startActivity(i);
            }
        });

    }
}