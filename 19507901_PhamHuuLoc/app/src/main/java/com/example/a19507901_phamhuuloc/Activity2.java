package com.example.a19507901_phamhuuloc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class Activity2 extends AppCompatActivity {

    TextView tv;
    ListView lv;
    String[] ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tv=findViewById(R.id.tv);
        lv= findViewById(R.id.lv);
        ls = null;
        getAllFile();

        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s= ls[position];
                try {
                    FileInputStream f = openFileInput(s);
                    ObjectInputStream o = new ObjectInputStream(f);
                    Sach sach;
                    lv.setItemChecked(position,false);

                    CheckedTextView v = (CheckedTextView) view;
                    boolean currentCheck = v.isChecked();

                    if (currentCheck == false){
                        ((ListView) lv).setItemChecked(position, false);
                    }else{
                        ((ListView) lv).setItemChecked(position, true);
                        v.setChecked(true);
                        for(;;){
                            try {
                                sach = (Sach) o.readObject();
                                tv.setText(sach.toString());
                            }catch (Exception e){
                                break;
                            }
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(Activity2.this, "Đọc không thành công", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }

    public void getAllFile(){
        ls=Activity2.this.fileList();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(Activity2.this,  android.R.layout.simple_list_item_checked, ls);
        lv.setAdapter(adapter);
    }
//    public void getAllFile(){
//        ls=Activity2.this.fileList();
//        customList adapter = new customList(Activity2.this, ls);
//        lv.setAdapter(adapter);
//    }
}