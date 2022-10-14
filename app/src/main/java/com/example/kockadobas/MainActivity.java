package com.example.kockadobas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView kocka1, kocka2;
    private Button kokca1Btn, kocka2Btn, dobasBtn, resetBtn;
    private TextView eredmeny;
    private Random rnd;
    private int dobas1;
    private int dobas2;
    private AlertDialog.Builder jatekVege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        kokca1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kocka2.setVisibility(View.GONE);
            }
        });

        kocka2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kocka2.setVisibility(View.VISIBLE);
            }
        });

        dobasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rnd = new Random();
                dobas1 = rnd.nextInt(6) + 1;
                dobas2 = rnd.nextInt(6) + 1;

                if (kocka2.getVisibility() == View.GONE) {
                    eredmeny.append(String.valueOf(dobas1) + "\n");
                    switch (dobas1) {
                        case 1:
                            kocka1.setImageResource(R.drawable.kocka1);
                            break;
                        case 2:
                            kocka1.setImageResource(R.drawable.kocka2);
                            break;
                        case 3:
                            kocka1.setImageResource(R.drawable.kocka3);
                            break;
                        case 4:
                            kocka1.setImageResource(R.drawable.kocka4);
                            break;
                        case 5:
                            kocka1.setImageResource(R.drawable.kocka5);
                            break;
                        case 6:
                            kocka1.setImageResource(R.drawable.kocka6);
                            break;
                    }
                } else {
                    int osszes = dobas1 + dobas2;
                    eredmeny.append(String.format("%d (%d + %d)", osszes, dobas1, dobas2) + "\n");

                    switch (dobas1) {
                        case 1:
                            kocka1.setImageResource(R.drawable.kocka1);
                            break;
                        case 2:
                            kocka1.setImageResource(R.drawable.kocka2);
                            break;
                        case 3:
                            kocka1.setImageResource(R.drawable.kocka3);
                            break;
                        case 4:
                            kocka1.setImageResource(R.drawable.kocka4);
                            break;
                        case 5:
                            kocka1.setImageResource(R.drawable.kocka5);
                            break;
                        case 6:
                            kocka1.setImageResource(R.drawable.kocka6);
                            break;
                    }

                    switch (dobas2) {
                        case 1:
                            kocka2.setImageResource(R.drawable.kocka1);
                            break;
                        case 2:
                            kocka2.setImageResource(R.drawable.kocka2);
                            break;
                        case 3:
                            kocka2.setImageResource(R.drawable.kocka3);
                            break;
                        case 4:
                            kocka2.setImageResource(R.drawable.kocka4);
                            break;
                        case 5:
                            kocka2.setImageResource(R.drawable.kocka5);
                            break;
                        case 6:
                            kocka2.setImageResource(R.drawable.kocka6);
                            break;
                    }
                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekVege.setMessage("Biztos, hogy törölni szeretnéd az eddigi dobásokat?");
                jatekVege.setTitle("Reset");
                jatekVege.setCancelable(false);
                jatekVege.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                jatekVege.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        eredmeny.setText("");
                        kocka1.setImageResource(R.drawable.kocka1);
                        kocka2.setImageResource(R.drawable.kocka1);
                    }
                });
                jatekVege.create().show();
            }
        });
    }

    private void init() {
        kocka1 = findViewById(R.id.kocka1);
        kocka2 = findViewById(R.id.kocka2);

        kokca1Btn = findViewById(R.id.kocka1_btn);
        kocka2Btn = findViewById(R.id.kocka2_btn);
        dobasBtn = findViewById(R.id.dobas_btn);
        resetBtn = findViewById(R.id.reset_btn);

        eredmeny = findViewById(R.id.eredmeny);

        jatekVege = new AlertDialog.Builder(MainActivity.this);
    }
}