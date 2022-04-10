package com.example.listview_spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<SanPham> ls= new ArrayList<>();

    public CustomAdapter(Context context, List<SanPham> ls) {
        this.context = context;
        this.ls = ls;
        this.inflater=LayoutInflater.from(context);

    }

    public CustomAdapter(LayoutInflater inflater, List<SanPham> ls) {
        this.ls = ls;
        this.inflater=inflater;

    }

    @Override
    public int getCount() {
        return ls.size();
    }

    @Override
    public Object getItem(int i) {
        return ls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = inflater.inflate(R.layout.custom_grid, null);
        }

        ImageView imgSP= view.findViewById(R.id.imgSP);
        TextView tvten = view.findViewById(R.id.tvten);
        TextView tvgia = view.findViewById(R.id.tvgia);

        imgSP.setImageResource(ls.get(i).getImgSP());
        tvten.setText(ls.get(i).getTen());
        tvgia.setText(String.valueOf(ls.get(i).getGia()) + " đồng");

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, ls.get(i).getTen(), Toast.LENGTH_SHORT).show();
//                positionselected =  i;
//                notifyDataSetChanged();
//            }
//        });
        return view;
    }
}
