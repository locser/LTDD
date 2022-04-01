package com.locser.ontapandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnChoi2, btnChoi3, btnChoi4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ
        btnChoi2 = findViewById(R.id.btnChoi2 );
        btnChoi3 = findViewById(R.id.btnChoi3);
        btnChoi4= findViewById(R.id.btnChoi4);


//        Set OnclickListener
        btnChoi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TODO: Chuyển qua màn hình 2
                Intent intent = new Intent(MainActivity.this, Dua2.class);
                //start hành động
                startActivity(intent);
            }
        });

        btnChoi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TODO: Chuyển qua màn hình 2
                Intent intent = new Intent(MainActivity.this, Dua3.class);
                //start hành động
                startActivity(intent);
            }
        });

        btnChoi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TODO: Chuyển qua màn hình 2
                Intent intent = new Intent(MainActivity.this, Dua4.class);
                //start hành động
                startActivity(intent);
            }
        });
    }
}