package com.example.bt_ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgPhone;
    Button chonMau;
    Button mua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPhone = findViewById(R.id.igPhone);
        chonMau = findViewById(R.id.btnChonMau);
        mua = findViewById(R.id.btnMua);

        chonMau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activiti2.class);
                startActivityForResult(intent, 999);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==999 && resultCode == RESULT_OK)
            imgPhone.setImageResource(data.getIntExtra("str",0));
    }
}