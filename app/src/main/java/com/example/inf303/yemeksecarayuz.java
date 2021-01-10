package com.example.inf303;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class yemeksecarayuz extends AppCompatActivity {
    public String choosen;
    public String[] yemek = new String[1000]; //Lebensmittel von SQL Table(Yemekler_table)
    public ImageView btn_onceki_sayfa;
    private AutoCompleteTextView yemek_ara;
    private ImageView btn_yemek_ekle;
    public ImageView yemek_ekle_arayuz_btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemeksecarayuz);
        final Database_Yemek myDb;
        myDb = new Database_Yemek(this);

        List<Yemek> tempYemek;
        tempYemek = myDb.getYemek();

        String[] yemeks = new String[tempYemek.size()];
        for (int i = 0; i < tempYemek.size(); i++) {
            yemeks[i] = tempYemek.get(i).getNAME();

        }
        yemek_ekle_arayuz_btn_home = findViewById(R.id.yemek_ekle_arayuz_btn_home);
        btn_yemek_ekle = findViewById(R.id.yemek_ekle_arayuz_btn_ekle);
        yemek_ara = findViewById(R.id.yemek_ekle_arama_cubugu);
        btn_onceki_sayfa = findViewById(R.id.yemek_ekle_arayuz_btn_geri_sayfa);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, yemeks);
        yemek_ara.setAdapter(adapter);


        yemek_ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_yemek_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_yemek_ekle_onClick(v);
                choosen = yemek_ara.getText().toString();
                System.out.println(choosen);
                myDb.getData(choosen);
                System.out.println("tabloya eklendi.");
                Toast.makeText(getApplicationContext(), R.string.Toast_yemek_1, Toast.LENGTH_LONG).show();

            }

        });


        btn_onceki_sayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent geri_yemek_ara = new Intent(yemeksecarayuz.this, Yemekara_Arayuz.class);
                startActivity(geri_yemek_ara);

            }
        });


        yemek_ekle_arayuz_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                startActivity(i);
            }
        });


    }

    private void btn_yemek_ekle_onClick(View v) {


    }


}
