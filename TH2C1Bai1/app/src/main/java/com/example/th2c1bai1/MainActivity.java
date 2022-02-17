package com.example.th2c1bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTong, btnHieu, btnTich, btnThuong, btnUCLN, btnThoat;
    TextView tvkq;
    EditText edtsoA, edtsoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init() {
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);
        btnUCLN= findViewById(R.id.btnUCLN);
        btnThoat= findViewById(R.id.btnThoat);

        tvkq = findViewById(R.id.tvKq);

        edtsoA= findViewById(R.id.edtSo1);
        edtsoB = findViewById(R.id.edtSo2);




        btnTong.setOnClickListener(this);
        btnHieu.setOnClickListener(this);
        btnTich.setOnClickListener(this);
        btnThuong.setOnClickListener(this);
        btnUCLN.setOnClickListener(this);
        btnThoat.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        double a,b;
        a = Double.parseDouble(edtsoA.getText().toString().trim());
        b = Double.parseDouble(edtsoB.getText().toString().trim());
        switch (view.getId()) {
            case R.id.btnTong:{
                double kq = a+ b;
                tvkq.setText(String.valueOf(kq));
            };break;
            case R.id.btnHieu:{
                double kq = a - b;
                tvkq.setText(String.valueOf(kq));
            };break;
            case R.id.btnTich:{
                double kq = a*b;
                tvkq.setText(String.valueOf(kq));
            };break;
            case R.id.btnThuong:{
                if(b==0) {
                    tvkq.setText("Phép tính không hợp lệ");
                }else {
                    double kq = a / b;
                    tvkq.setText(String.valueOf(kq));
                }
            };break;
            case R.id.btnUCLN:{
                while (a != b) {
                    if(a > b)
                        a = a - b;
                    else
                        b = b - a;
                }
                double kq =b;
                tvkq.setText(String.valueOf(b));
            };break;
            case R.id.btnThoat:{
                finish();
            };break;
        }
    }
}