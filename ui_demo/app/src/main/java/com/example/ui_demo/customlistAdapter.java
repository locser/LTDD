package com.example.ui_demo;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class customlistAdapter extends BaseAdapter {

    LayoutInflater inflater;
    List<NhanVien> listnv;
    Context context;

    public customlistAdapter(Context context, List<NhanVien> listnv) {

        this.listnv = listnv;
        this.context = context;
        this.inflater = (LayoutInflater.from(context)) ;
    }

    @Override
    public int getCount() {
        return listnv.size();
    }

    @Override
    public Object getItem(int i) {
        return listnv.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = inflater.inflate(R.layout.customadapter, null);
        }

        ImageView imgdaidien = view.findViewById(R.id.imgdaidien);
        TextView tvten = view.findViewById(R.id.tvTen);
        TextView tvid= view.findViewById(R.id.tvId);
        TextView tvpb = view.findViewById(R.id.tvPB);

        tvid.setText("ID: "+ listnv.get(i).getMaNV());
        tvten.setText("Tên: "+ listnv.get(i).getTenNV());
        tvpb.setText("PB: "+ listnv.get(i).getDonvi());
        String uri= listnv.get(i).getImageUri();
        if((!uri.equals(""))){
            imgdaidien.setImageURI(Uri.parse(uri));
        }else{
            imgdaidien.setImageResource(R.drawable.iconprivatepeople);
        }
        return view;
    }
}
