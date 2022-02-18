package com.example.th2c1bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String cmnd, bangcap;
    String name, bosung ;
    String sothich="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtname, edtcmnd, edtBosung;
        RadioButton rbtnCD, rbtnDH, rbtnTC;
        CheckBox cbxDocbao, cbxDocsach, cbxDoccode;
        Button btnGui;



        edtname = findViewById(R.id.edtName);
        edtcmnd = findViewById(R.id.edtCMND);
        edtBosung = findViewById(R.id.edtBoSung);

        rbtnCD = findViewById(R.id.radioCD);
        rbtnDH = findViewById(R.id.radioDH);
        rbtnTC = findViewById(R.id.radioTC);

        cbxDocbao = findViewById(R.id.chbDocbao);
        cbxDocsach = findViewById(R.id.chbDocsach);
        cbxDoccode = findViewById(R.id.chbDoccode);

        btnGui = findViewById(R.id.btnGui);


        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 name =  edtname.getText().toString().trim();
                 cmnd =  edtcmnd.getText().toString();
                 sothich="";
                 if (rbtnTC.isChecked()) {
                     bangcap = "Trung Cấp";
                 }
                if (rbtnCD.isChecked()) {
                    bangcap = "Cao Đẳng";
                }
                if (rbtnDH.isChecked()) {
                    bangcap = "Đại học";
                }
                if(cbxDocbao.isChecked()){
                    sothich+= "Đọc báo";
                }
                if(cbxDocsach.isChecked()){
                    sothich+= ", Đọc Sách";
                }
                if(cbxDoccode.isChecked()){
                    sothich+= ", Đọc Code";
                }
                if (sothich.startsWith(", ")){
                    sothich=sothich.substring(2, sothich.length());
                }
                bosung= edtBosung.getText().toString().trim();
                
                if(name.isEmpty()|| cmnd.isEmpty() || !kiemtra(name,cmnd)){
                    Toast.makeText(MainActivity.this, "Hãy nhập đầy đủ tên gòm ít nhất 3 kí tự và CMND gồm 9 chữ số ", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("name", name);
                    intent.putExtra("cmnd", cmnd);
                    intent.putExtra("bangcap", bangcap);
                    intent.putExtra("sothich", sothich);
                    intent.putExtra("bosung", bosung);
                    startActivity(intent);

                }

            }
        });
    }

    public boolean kiemtra(String name, String cmnd){
        String parName= "(\\D{3,})";
        String parcmnd = "[0-9]{9}";

    if((name.matches(parName)== true) && (cmnd.matches(parcmnd))){
        return true;
    }
        return false;
    }

}