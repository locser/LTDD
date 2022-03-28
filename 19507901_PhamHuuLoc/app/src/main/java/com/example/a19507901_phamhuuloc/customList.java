package com.example.a19507901_phamhuuloc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class customList extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    String[] ls;


    public customList(Context context, String[] ls) {
        this.context = context;
        this.ls = ls;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ls.length;
    }

    @Override
    public Object getItem(int position) {
        return ls[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView== null){
            convertView=inflater.inflate(R.layout.activity_custom_list, null);
        }
        TextView tv= convertView.findViewById(R.id.tvTencus);
        CheckBox checkBox = convertView.findViewById(R.id.ckb);

        tv.setText(ls[position]);
        return convertView;
    }
}