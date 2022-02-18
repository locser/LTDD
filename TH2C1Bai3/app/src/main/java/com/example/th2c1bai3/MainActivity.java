package com.example.th2c1bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnChuyen =findViewById(R.id.btnChuyen);
        EditText edtnam= findViewById(R.id.edtNam);
        TextView tvAmlich = findViewById(R.id.tvAmlich);

        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strcan= "";
                String strchi="";
                int nam = Integer.parseInt(edtnam.getText().toString().trim());
                if(nam < 1900){
                    Toast.makeText(MainActivity.this, "Hãy nhập năm lớn hơn 1900", Toast.LENGTH_SHORT).show();
                }else{
                    int can=  nam%10;
                    int chi= nam % 12;

                    switch (can){
                        case 0: {
                            strcan = "Canh";
                        };
                        case 1: {
                            strcan = "Tân";
                        };break;
                        case 2: {
                            strcan = "Nhâm";
                        };break;
                        case 3: {
                            strcan = "Quý";
                        };break;
                        case 4: {
                            strcan = "Giáp";
                        };break;
                        case 5: {
                            strcan = "Ất";
                        };break;
                        case 6: {
                            strcan = "Bính";
                        };break;
                        case 7: {
                            strcan = "Đinh";
                        };break;
                        case 8: {
                            strcan = "Mậu";
                        };break;
                        case 9: {
                            strcan = "Kỉ";
                        };break;
                    }

                    switch (chi){
                        case 0: {
                            strchi = "Thân";
                        };break;
                        case 1: {
                            strchi = "Dậu";
                        };break;
                        case 2: {
                            strchi = "Tuất";
                        };break;
                        case 3: {
                            strchi = "Hợi";
                        };break;
                        case 4: {
                            strchi = "Tý";
                        };break;
                        case 5: {
                            strchi = "Sửu";
                        };break;
                        case 6: {
                            strchi = "Dần";
                        };break;
                        case 7: {
                            strchi = "Mão";
                        };break;
                        case 8: {
                            strchi = "Thìn";
                        };break;
                        case 9: {
                            strchi = "Tỵ";
                        };break;
                        case 10: {
                            strchi = "Ngọ";
                        };break;
                        case 11: {
                            strchi = "Mùi";
                        };break;
                    }

                }


                tvAmlich.setText(strcan + " " + strchi);
            }
        });
    }
}