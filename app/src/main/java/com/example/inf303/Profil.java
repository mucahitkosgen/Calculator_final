package com.example.inf303;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Profil extends AppCompatActivity {
    private EditText namesurname, boy, kilo;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private ImageButton kayit2;
    private CheckBox btnDisplay;
    private ImageView imageView2;
    private ImageView btn_anasayfa;

    Databasee db;
    Hedef_kalori v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_profil);
        namesurname = (EditText) findViewById(R.id.namesurname);
        boy = (EditText) findViewById(R.id.boy);
        kilo = (EditText) findViewById(R.id.kilo);
        kayit2 = (ImageButton) findViewById(R.id.kayit2);
        btn_anasayfa = (ImageView) findViewById(R.id.btn_anasayfa);
        addListenerOnButton();
        db = new Databasee(this);
        v2 = new Hedef_kalori();
        final Context context = this;


        Button sprache = (Button) findViewById(R.id.sprache);
        sprache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // show AlertDialog to display list of languages, one can be selected.
                showChangeLanguageDialog();
            }
        });


        btn_anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                startActivity(i);
            }
        });


        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                startActivity(i);
            }
        });
        kayit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = namesurname.getText().toString();
                String b = boy.getText().toString();
                String c = kilo.getText().toString();
                if (a.equals("") || b.equals("") || c.equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris, Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Toast.makeText(getApplicationContext(), R.string.Toast_giris_2, Toast.LENGTH_LONG).show();
                    Boolean insert = db.insert(a, b, c);


                }

            }
        });


    }


    //  create separate strings.xml for each language
    private void showChangeLanguageDialog() {
        // array of languages to display in alert dialog
        final String[] listItems = {"Deutsch", "Türkçe"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Profil.this);
        mBuilder.setTitle(R.string.Toast_profil_1);
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    // deutsch
                    setLocale("de");
                    recreate();
                } else if (i == 1) {
                    // turkce
                    setLocale("tr");
                    recreate();
                }

                // dismiss alert dialog when language selected
                dialogInterface.dismiss();

            }
        });

        AlertDialog mDialog = mBuilder.create();
        // show alert dialog
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        // save data to shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }


    public void addListenerOnButton() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        btnDisplay = (CheckBox) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(Profil.this,
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });


    }
}