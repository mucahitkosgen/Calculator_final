package com.example.inf303;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Tarifler extends AppCompatActivity {

    RecyclerView recyclerView;
//    ImageView okk;

    String s1[], s2[];
    int images[] = {R.drawable.brownie, R.drawable.su, R.drawable.kecikek, R.drawable.karnabaharlikisir, R.drawable.veganpizza, R.drawable.yogurtlubrokoli, R.drawable.ezogelincorbasi, R.drawable.imambayildi, R.drawable.alinazik, R.drawable.mercimekcorbasi, R.drawable.lahana, R.drawable.portakallikereviz, R.drawable.semizotusalatasi, R.drawable.makarna, R.drawable.kabak, R.drawable.brokolikofte, R.drawable.elmaliturta, R.drawable.barbunya, R.drawable.cheesecake, R.drawable.yogurtlucorbasi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        okk=(ImageView)findViewById(R.id.okk);
//        okk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
//                startActivity(i);
//            }
//        });

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.title);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}