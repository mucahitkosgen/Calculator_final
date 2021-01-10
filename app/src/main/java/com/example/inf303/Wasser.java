package com.example.inf303;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Wasser extends AppCompatActivity {
    Database_Su db;
    Wasser w;
    int x;

    //private Button w_button1,w_button2;
    ImageView imageViev1, imageViev2, imageViev3;
    TextView textView1, textView2;
    ImageButton w_button1;
    ImageButton w_button2;
    ImageView imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    TextView textView3;
    TextView ekrangoster;

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    private int ml;
    Hedef_kalori hk = new Hedef_kalori();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wasser);

        ekrangoster = (TextView) findViewById(R.id.ekrangoster);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        w_button1 = (ImageButton) findViewById(R.id.w_button1);
        w_button2 = (ImageButton) findViewById(R.id.w_button2);
        imageButton1 = (ImageView) findViewById(R.id.imageView4);


        imageViev1 = (ImageView) findViewById(R.id.imageView1);
        imageViev2 = (ImageView) findViewById(R.id.imageView2);
        imageViev3 = (ImageView) findViewById(R.id.imageView3);
        int y;

        db = new Database_Su(this);
        //v2=new ListDataActivity();
        //v3=new Kullaniciekle();
//
        final Context context = this;


        ekrangoster.setText(db.getData() + "");


        w_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    x = db.toplam(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                if (x < 1000) {
                    Toast.makeText(getApplicationContext(), R.string.Toast_su_1, Toast.LENGTH_LONG).show();
                }
                if (x > 5000) {
                    Toast.makeText(getApplicationContext(), R.string.Toast_su_2, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), R.string.Toast_su_3, Toast.LENGTH_LONG).show();
                }
                ekrangoster.setText(x + "");


                Toast.makeText(getApplicationContext(), R.string.Toast_su_kayit, Toast.LENGTH_LONG).show();
            }
        });
        //ekrangoster.setText(x+"");


        w_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  db.addData(500);

                try {
                    x = db.toplam(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(x);
                //x=x+500;




                Toast.makeText(getApplicationContext(), R.string.Toast_su_kayit, Toast.LENGTH_LONG).show();
                


            }
        });


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Hedef_kalori.class);
                startActivity(i);

            }
        });


    }

}
