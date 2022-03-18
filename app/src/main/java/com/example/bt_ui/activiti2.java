package com.example.bt_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class activiti2 extends AppCompatActivity {
    int index;
    ImageView ivPhoneSub;
    ImageView ivBac;
    ImageView ivDo;
    ImageView ivDen;
    ImageView ivXanh;
    Button btnXong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activiti2);

        ivPhoneSub = findViewById(R.id.ivPhoneSub);
        ivBac = findViewById(R.id.ivBac);
        ivDo = findViewById(R.id.ivDo);
        ivDen = findViewById(R.id.ivDen);
        ivXanh = findViewById(R.id.ivXanh);
        btnXong = findViewById(R.id.btnXong);

        ivBac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivPhoneSub.setImageResource(R.drawable.vs_bac_1);
                index = R.drawable.vs_bac_1;
            }
        });
        ivDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivPhoneSub.setImageResource(R.drawable.vs_red_a_2);
                index = R.drawable.vs_red_a_2;
            }
        });
        ivDen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivPhoneSub.setImageResource(R.drawable.vsmart_black_star_1);
                index = R.drawable.vsmart_black_star_1;
            }
        });
        ivXanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivPhoneSub.setImageResource(R.drawable.vsmart_live_xanh_1);
                index = R.drawable.vsmart_live_xanh_1;
            }
        });

        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trave =new Intent();
                trave.putExtra("str", index);
                setResult(RESULT_OK, trave);
                finish();
            }
        });
    }
}