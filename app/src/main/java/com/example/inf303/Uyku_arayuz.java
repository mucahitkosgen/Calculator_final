package com.example.inf303;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Uyku_arayuz extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {


    Database_Uyku mDatabase;
    public Button btn_uyku_ekle, btn_anasayfa, btn_tarifler, btn_ayarlar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyku_arayuz);


        final ImageView btn_anasayfa = (ImageView) findViewById(R.id.btn_anasayfa);
        final Button btn_uyku_ekle = (Button) findViewById(R.id.btn_uyku_ekle);

        mDatabase = new Database_Uyku(this);
        getDataCalistir();


        btn_uyku_ekle.setOnClickListener(new View.OnClickListener() {    // Saat seçim arayuzunu aciyoruz
            @Override
            public void onClick(View v) {
                CharSequence saat = btn_uyku_ekle.getText();
                CharSequence dakika = btn_uyku_ekle.getText();
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });


        btn_anasayfa.setOnClickListener(new View.OnClickListener() {   // btn_anasayfa butonuyla Hedef_kalori classina geciyoruz
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                startActivity(i);
            }
        });


    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) { // Sectigimiz  hourOfDay ve minute degerlerini Textview'da gosteriyoruz.

        TextView saat = (TextView) findViewById(R.id.saat);
        TextView dakika = (TextView) findViewById(R.id.dakika);
        saat.setText(hourOfDay + "  : ");
        dakika.setText(minute + "  : ");
        System.out.println(hourOfDay);
        System.out.println(minute);

//        Toast.makeText(this, R.string.toast, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, R.string.Toast_uyku_1, Toast.LENGTH_LONG).show();

        addData(hourOfDay, minute);
    }


    public void getDataCalistir() { // Textview saat ve dakika gozuken degerleri uygulamaya tekrar giris yaptigimiz da gormek icin
        TextView saat = (TextView) findViewById(R.id.saat);
        TextView dakika = (TextView) findViewById(R.id.dakika);

        saat.setText(mDatabase.getData() + "  : ");
        dakika.setText(mDatabase.getData2() + "  : ");
    }


    public void addData(int hourOfDay, int minute) { // hourOfDay ve minute degerlerini veritabanina ekliyoruz

        boolean insert;
        if (mDatabase.addData(hourOfDay, minute)) {
            insert = true;
//            Toast.makeText(this, R.string.toast2, Toast.LENGTH_LONG).show();
//            toastMessage("Veritabanina eklendi.");
        } else {
            insert = false;
//            toastMessage("Eklenemedi");
        }
    }


    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
