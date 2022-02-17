package com.example.th2c1bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btntoF =findViewById(R.id.btnToF);
        Button btntoC =findViewById(R.id.btnToC);
        Button btnClear =findViewById(R.id.btnClear);

        EditText edtF =  findViewById(R.id.edtF);
        EditText edtC =  findViewById(R.id.edtC);


        btntoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double C = Double.parseDouble(edtC.getText().toString().trim());
                double kq = C * 9/5 +32;
                edtF.setText(String.valueOf(kq));
            }
        });
        btntoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double F = Double.parseDouble(edtF.getText().toString().trim());
                double kq =( F-32) * 5 /9;
                edtC.setText(String.valueOf(kq));
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("");
                edtF.setText("");
            }
        });

    }
}