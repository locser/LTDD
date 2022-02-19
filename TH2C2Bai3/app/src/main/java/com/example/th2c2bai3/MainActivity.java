package com.example.th2c2bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    EditText edtName;
    Button btnNhap;
    TextView tv;
    ArrayList<String> list;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv= findViewById(R.id.lv);
        edtName= findViewById(R.id.edtName);
        btnNhap=  findViewById(R.id.btnNhap);
        tv= findViewById(R.id.tv);

        list= new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(edtName.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText("Index: " +i+   "\t value: " + list.get(i));
            }
        });
    }
}