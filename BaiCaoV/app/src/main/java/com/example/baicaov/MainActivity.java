package com.example.baicaov;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnPlayervBot, btnBotvBot;
    View viewAlertPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        btnPlayervBot = findViewById(R.id.btnChoiVoiMay);
        btnBotvBot = findViewById(R.id.btnTuChoi);

        btnPlayervBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Tạo đường dẫn view
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                viewAlertPlayer =  inflater.inflate(R.layout.activity_alert_playerv_bot, null);

                //random Tên Player
                String[] lsTen= {"Alex", "Lion", "Anna", "Lucifer", "Rumm", "Chipfer", "ALan", "Harry", "Lala", "Fing"};



                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(viewAlertPlayer);
                builder.setMessage("Hãy nhập tên của bạn: ");


                builder.setPositiveButton("Chơi ngay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EditText edtTen = viewAlertPlayer.findViewById(R.id.edtTenPlayer);
                        try {
                            Intent intent = new Intent(MainActivity.this, ChoiVoiMayActivity.class);
                            String ten =edtTen.getText().toString();
                            if (ten.length() ==0){
                                Random rand = new Random();
                                int randomNum = rand.nextInt((9 - 0) + 1) + 0;
                                //int randomNum = rand.nextInt((max - min) + 1) + min;
                                ten= lsTen[randomNum];
                            }
                            intent.putExtra("ten", ten);
                            intent.putExtra("Loai", "PlayervBot");
                            startActivity(intent);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });

                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });


                builder.create().show();
            }
        });





        btnBotvBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Tạo đường dẫn view
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                viewAlertPlayer =  inflater.inflate(R.layout.activity_alert_playerv_bot, null);

//
                //random Tên Player
//                String[] lsTen= {"Alex", "Lion", "Anna", "Lucifer", "Rumm", "Chipfer", "ALan", "Harry", "Lala", "Fing"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(viewAlertPlayer);
                builder.setMessage("Hãy nhập thời gian muốn tự chơi (Giây): ");


                builder.setPositiveButton("Chơi ngay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, ChoiVoiMayActivity.class);


                        EditText tvTen = viewAlertPlayer.findViewById(R.id.edtTenPlayer);
                        int time=0;
                        try {
                            String strTime= tvTen.getText().toString().trim();
                            time =Integer.parseInt(strTime);
                            intent.putExtra("time",String.valueOf(time));
                            intent.putExtra("Loai", "BotvBot");
                            startActivity(intent);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, "Hãy nhập số nguyên dương", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }


                    }
                });

                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });


                builder.create().show();
            }
        });
    }
}