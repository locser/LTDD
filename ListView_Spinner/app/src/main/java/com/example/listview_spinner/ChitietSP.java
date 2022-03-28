package com.example.listview_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ChitietSP extends AppCompatActivity {

    TextView tvten, tvgia, tvloaisp, tvdungtich, tvthuonghieu,tvnoisx;
    ImageView imgSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_sp);

        init();

        Intent intent=this.getIntent();
    }

    public void init(){
        tvten = findViewById(R.id.tvten);
        tvgia = findViewById(R.id.tvgia);
        tvloaisp = findViewById(R.id.tvloaisp);
        tvdungtich = findViewById(R.id.tvdungtich);
        tvthuonghieu   = findViewById(R.id.tvthuonghieu);
        tvnoisx = findViewById(R.id.tvnoisanxuat);
        imgSP = findViewById(R.id.imgSP);
    }
}