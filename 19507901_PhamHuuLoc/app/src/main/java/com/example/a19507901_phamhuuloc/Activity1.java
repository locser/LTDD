package com.example.a19507901_phamhuuloc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Activity1 extends AppCompatActivity {

    EditText edtten, edttacgia,edtnhaxb, edtnamsx;
    Button btnnhapmoi, btnluu;
    List<Sach> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        edtten = findViewById(R.id.edtTensach);
        edttacgia = findViewById(R.id.edtTentg);
        edtnhaxb = findViewById(R.id.edtNhaxb);
        edtnamsx = findViewById(R.id.edtNam);
        btnluu = findViewById(R.id.btnLuu);
        btnnhapmoi = findViewById(R.id.btnNhapMoi);

        btnnhapmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtten.setText("");
                edtnamsx.setText("");
                edtnhaxb.setText("");
                edttacgia.setText("");
            }
        });

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tensach = edtten.getText().toString();
                String tacgia = edttacgia.getText().toString();
                String nhaxb = edtnhaxb.getText().toString();
                String nam = edtnamsx.getText().toString();
                
                if (tensach.length()>0 && tacgia.length()>0) {
                    try {
                        int namxb = Integer.parseInt(nam);
                        Sach s = new Sach(tensach, tensach,nhaxb, namxb);
                        FileOutputStream f = openFileOutput(s.getTen()+ ".txt", MODE_PRIVATE);
                        ObjectOutputStream o =  new ObjectOutputStream(f);
                        o.writeObject(s);
                        Toast.makeText(Activity1.this, "Lưu thành công: "+ getFilesDir(), Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Toast.makeText(Activity1.this, "Năm phải là số", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(Activity1.this, "Hãy Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}