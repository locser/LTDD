package com.example.th2c1bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    String cmnd, bangcap, sothich;
    String name, bosung ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tvkq = findViewById(R.id.tvkq);

        Intent bundle = this.getIntent();

        String name = bundle.getStringExtra("name");
        String cmnd = bundle.getStringExtra("cmnd");
        String bangcap = bundle.getStringExtra("bangcap");
        String sothich = bundle.getStringExtra("sothich");
        String bosung = bundle.getStringExtra("bosung");

        tvkq.setText(name + "\n" + cmnd+"\n" +bangcap+"\n" +sothich+"\n" +bosung);
    }
}