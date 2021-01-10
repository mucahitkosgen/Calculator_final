package com.example.inf303;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Hedef_kalori extends AppCompatActivity {
    public EditText kilogir, k2, su_litre, boy, k6;
    private ImageButton kayit, giris, tarif, ayarlar, ok1, ok2, ok3;
    private TextView textView, textView5, textView6, kalori_yazi, suy_yazi, uyku_yazi;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hedef_kalori);
        textView = (TextView) findViewById(R.id.textView);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        kilogir = (EditText) findViewById(R.id.kilogir);
        boy = (EditText) findViewById(R.id.boy);
        k2 = (EditText) findViewById(R.id.k2);
        kayit = (ImageButton) findViewById(R.id.kayit);
        giris = (ImageButton) findViewById(R.id.giris);
        tarif = (ImageButton) findViewById(R.id.tarif);
        ayarlar = (ImageButton) findViewById(R.id.ayarlar);
        ok1 = (ImageButton) findViewById(R.id.ok1);
        ok2 = (ImageButton) findViewById(R.id.ok2);
        ok3 = (ImageButton) findViewById(R.id.ok3);
        su_litre = (EditText) findViewById(R.id.su_litre);
        k6 = (EditText) findViewById(R.id.k6);

        //Wir haben andere Schnittstellendatenbanken auf diese Schnittstelle gezogen und die Daten auf die Homepage gezogen.
        Database_Su db_su = new Database_Su(this);
        su_litre.setText(db_su.getData() + "");

        Database_Uyku db_uyku = new Database_Uyku(this);
        k6.setText(db_uyku.getData() + ":" + db_uyku.getData2() + "");

        Database_Yemek db_yemek = new Database_Yemek(this);
        k2.setText(db_yemek.getData2() + "");


        final Context context = this;
        tarif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Der Code, der zum Wechseln zwischen Klassen verwendet wird, ist beabsichtigt
                Intent i = new Intent(getApplicationContext(), Tarifler.class);
                startActivity(i);
            }
        });
        ayarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Profil.class);
                startActivity(i);
            }
        });
        ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Yemekara_Arayuz.class);
                startActivity(i);
            }
        });
        ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Wasser.class);
                startActivity(i);
            }
        });
        ok3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Uyku_arayuz.class);
                startActivity(i);
            }
        });
        su_litre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(su_litre.getText().toString());
                if (x >= 0 && x < 2) {
                    TextView textView5 = (TextView) findViewById(R.id.textView5);
                    textView5.setText("2 litre daha su için");
                    return;
                } else if (x >= 2 && x < 3) {
                    TextView textView5 = (TextView) findViewById(R.id.textView5);
                    textView5.setText("1 litre daha su için");
                    return;
                } else if (x == 3) {
                    TextView textView5 = (TextView) findViewById(R.id.textView5);
                    textView5.setText("Her gün yeterli su");
                    return;
                } else if (x > 3) {
                    TextView textView5 = (TextView) findViewById(R.id.textView5);
                    textView5.setText("Günlük fazla su tüketimi 3 litre ideal");

                    return;
                }
            }
        });
        k6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int y = Integer.parseInt(k6.getText().toString());
                if (y >= 1 && y < 2) {
                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("6 saat daha uyu");
                    return;
                } else if (y == 0) {
                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("7 saat daha uyu");
                    return;
                } else if (y >= 2 && y < 3) {
                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("5 saat daha uyu");
                    return;
                } else if (y >= 3 && y < 4) {
                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("4 saat daha uyu");
                    return;
                } else if (y >= 4 && y < 5) {
                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("3 saat daha uyu");
                    return;
                } else if (y >= 5 && y < 6) {
                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("2 saat daha uyu");
                    return;
                } else if (y >= 6 && y < 7) {
                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("1 saat daha uyu");
                    return;
                } else if (y == 7) {
                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("Yeterli uyku süresi");
                    return;
                } else {
                    TextView textView6 = (TextView) findViewById(R.id.textView6);
                    textView6.setText("Aşırı günlük uyku 7 saat ideal");
                    return;
                }

            }
        });

        k2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(kilogir.getText().toString());
                int b = Integer.parseInt(k2.getText().toString());
                int c = Integer.parseInt(boy.getText().toString());


                if (50 >= a && a >= 40 && c >= 140 && c <= 185) {
                    if (b >= 500 && b <= 1000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("1000 kaloriye ihtiyacınız var");
                        return;
                    } else if (b > 1000 && b <= 1500) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ek 200-300 kaloriye ihtiyacınız olacak");
                        return;
                    } else if (b == 1500) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("İdeal günlük kalori");
                        return;
                    } else if (b > 1500) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Fazla kalori tüketimi, 1500 kalori ideal");
                        return;
                    }
                }
                else if (60 >= a && a > 50 && c >= 140 && c <= 200) {
                    if (b >= 500 && b < 1000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ek 1100 kaloriye ihtiyacınız var");
                        return;
                    } else if (b >= 1000 && b < 1700) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ek 300-400 kaloriye ihtiyacınız var");
                        return;
                    } else if (b == 1700) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("İdeal günlük kalori");
                        return;
                    } else if (b > 1700) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Fazla kalori tüketimi, 1700 kalori ideal");
                        return;
                    }
                }
                else if (70 >= a && a > 60 && c >= 150 && c <= 210) {
                    if (b >= 500 && b < 1000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ekstra 1200 kaloriye ihtiyacınız var");
                        return;
                    } else if (b >= 1000 && b < 1800) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ek 400-500 kaloriye ihtiyacınız olacak");
                        return;
                    } else if (b == 1800) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("İdeal günlük kalori");
                        return;
                    } else if (b > 1800) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Fazla kalori tüketimi,1800 kalori ideal");
                        return;
                    }
                }
                else if (80 >= a && a > 70 && c >= 150 && c <= 220) {
                    if (b >= 500 && b < 1000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ek 1300 kaloriye ihtiyacınız var");
                        return;
                    } else if (b >= 1000 && b < 1900) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ek bir 500-600 kaloriye ihtiyacınız var");
                        return;
                    } else if (b == 1900) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("İdeal günlük kalori");
                        return;
                    } else if (b > 1900) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Fazla kalori tüketimi,1900 kalori ideal");
                        return;
                    }
                }
                else if (90 >= a && a > 80 && c >= 150 && c <= 230) {
                    if (b >= 500 && b < 1000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ek 1450 kaloriye ihtiyacınız var");
                        return;
                    } else if (b >= 1000 && b < 2000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ek bir 600-700 kaloriye ihtiyacınız var");
                        return;
                    } else if (b == 2000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("İdeal günlük kalori");
                        return;
                    } else if (b > 2000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Fazla kalori tüketimi,2000 kalori ideal");
                        return;
                    }
                }
                else if (100 >= a && a > 90 && c >= 160 && c <= 230) {
                    if (b >= 500 && b < 1000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ekstra 1600 kaloriye ihtiyacınız var");
                        return;
                    } else if (b >= 1000 && b < 2200) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ekstra 800-900 kaloriye ihtiyacınız var");
                        return;
                    } else if (b == 2200) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("İdeal günlük kalori");
                        return;
                    } else if (b > 2200) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Fazla kalori tüketimi,2200 kalori ideal");
                        return;
                    }
                }
                else if (110 >= a && a > 100 && c >= 165 && c <= 230) {
                    if (b >= 500 && b < 1000) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ekstra 1800 kaloriye ihtiyacınız var");
                        return;
                    } else if (b >= 1000 && b < 2300) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Ek 900-1000 kaloriye ihtiyacınız var");
                        return;
                    } else if (b == 2300) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("İdeal günlük kalori");
                        return;
                    } else if (b > 2300) {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Fazla kalori tüketimi,2300 kalori ideal");
                        return;
                    }
                }
                else if (a > 110 && c >= 140 && c <= 230) {
                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText("Acil diyet!!");
                    return;
                }
                else if (a < 40 && c >= 130 && c <= 220) {
                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText("Çok zayıfsınız,günlük 3000 kalori alın");
                    return;
                }

                else  {
                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText("Alanları boş bırakmayın");
                    return;

                }
                }

            private void toastMessage(String you_must_put_something) {
            }
        });


    }
}