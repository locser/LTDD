package com.example.th2c1bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnTinh, btnTiep, btnThongke, btnThoat;
    EditText edtname, edtSoluong;
    TextView tvThanhtien, tvTongkh, tvTongkhVip, tvDoanhthu;
    CheckBox cbxVip;
    final int giasach = 20000;
    int soKH =0;
    int soKHVIP= 0;
    int doanhthu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTinh = findViewById(R.id.btnTinhtt);
        btnTiep = findViewById(R.id.btnTiep);
        btnThongke = findViewById(R.id.btnThongke);
        btnThoat = findViewById(R.id.btnThoat);

        edtname = findViewById(R.id.edtName);
        edtSoluong = findViewById(R.id.edtSoluong);

        tvThanhtien = findViewById(R.id.tvThanhtien);
        tvTongkh = findViewById(R.id.tvTongKH);
        tvTongkhVip = findViewById(R.id.tvTongKHVIP);
        tvDoanhthu = findViewById(R.id.tvTongDoanhthu);

        cbxVip = findViewById(R.id.cbxVip);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strSoluong= (edtSoluong.getText().toString());
                int soluong= Integer.parseInt(strSoluong);
//                Toast.makeText(MainActivity.this, "n1", Toast.LENGTH_SHORT).show();
                    int giamgia= 0;
                    if (cbxVip.isChecked()){
                        giamgia=10;
                        soKHVIP++;
                    }

                    int thanhtien = soluong * giasach * (100-giamgia) /100;
                    tvThanhtien.setText(String.valueOf(thanhtien));
                    soKH++;
                    doanhthu+= thanhtien;

            }
        });

        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtname.setText("");
                edtSoluong.setText("");
                edtname.requestFocus();
            }
        });
        btnThongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTongkh.setText(String.valueOf(soKH));
                tvTongkhVip.setText(String.valueOf(soKHVIP));
                tvDoanhthu.setText(String.valueOf(doanhthu));
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}