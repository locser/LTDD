package com.example.ui_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Button btnIMG, btnthem, btnsua,btntruyvan;
    EditText edtten, edtma;
    RadioButton rbtnNam, rbtnNu;
    Spinner spinner;
    ArrayList<NhanVien> listNV, listNV2;
    String[] listPB;
    String donvi;
    //duong dan anh
    Uri imageUri;
    ImageView imgHinh;
    List<Uri> listImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv = findViewById(R.id.listview);
        ;
        imgHinh = findViewById(R.id.imgHinh);
        btnIMG = findViewById(R.id.btnImg);
        btnthem = findViewById(R.id.btnThem);
        btnsua = findViewById(R.id.btnSua);
        btntruyvan = findViewById(R.id.btnTruyvan);
        edtten = findViewById(R.id.edtTen);
        edtma = findViewById(R.id.edtMa);
        rbtnNam = findViewById(R.id.rbtnNam);
        rbtnNu = findViewById(R.id.rbtnNu);
        spinner = findViewById(R.id.spinner);

        listNV = new ArrayList<NhanVien>();
        listPB = getResources().getStringArray(R.array.donvi_list);
        ArrayAdapter<String> adapterListPB = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listPB);

        //uri ảnh
        listImageUri = new ArrayList<>();

        spinner.setAdapter(adapterListPB);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = listPB[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        customlistAdapter adapterNV = new customlistAdapter(this, listNV);
        lv.setAdapter(adapterNV);


        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String maso = edtma.getText().toString();
                String ten = edtten.getText().toString();
                if((maso.length() >0) && (ten.length()>0) ){
                    String gioitinh = (rbtnNam.isChecked()) ? "Nam" : "Nữ";

                    Drawable d = imgHinh.getDrawable();

                    NhanVien nv = new NhanVien(maso, ten, gioitinh, donvi, d );


                    listNV.add(nv);
                    lv.deferNotifyDataSetChanged();
                }else {
                    Toast.makeText(MainActivity.this, "Hãy Nhập đầy đủ thông tin của nhân viên", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i= lv.getSelectedItemPosition();
                if(i<=0 || i >listNV.size()){
                    Toast.makeText(MainActivity.this, "Hãy chọn một nhân viên nào đóa đi nè!", Toast.LENGTH_SHORT).show();
                }else{
                    String maso = edtma.getText().toString();
                    String ten = edtten.getText().toString();
                    if((maso.length() >0) && (ten.length()>0) ){
                        String gioitinh = (rbtnNam.isChecked()) ? "Nam" : "Nữ";

                        Drawable d = imgHinh.getDrawable();

                        listNV.get(i).setMaNV(maso);
                        listNV.get(i).setTenNV(ten);
                        listNV.get(i).setGioitinh(gioitinh);
                        listNV.get(i).setDonvi(donvi);
                        listNV.get(i).setD(d);

                        lv.deferNotifyDataSetChanged();
                    }else {
                        Toast.makeText(MainActivity.this, "Hãy Nhập đầy đủ thông tin của nhân viên", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        btntruyvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maso = edtma.getText().toString();
                String ten = edtten.getText().toString();
                int i=-1;
                if((maso.length() >0)){
                    for (int j = 0 ; j< listNV.size(); j++){
                        if(maso.equals(listNV.get(j).getMaNV()))
                            i=j;
                    }
                    if(i!= -1){
//
                        Toast.makeText(MainActivity.this, "Tìm thấy nhân viên", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Không Tìm thấy nhân viên", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    if((ten.length() >0)){
                        for (int j = 0 ; j< listNV.size(); j++){
                            if(ten.equals(listNV.get(j).getTenNV()))
                                i=j;
                        }
                        if(i!= -1){

                            Toast.makeText(MainActivity.this, "Tìm thấy nhân viên", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Không Tìm thấy nhân viên", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Hãy nhập 1 hoặc 2 dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv = listNV.get(i);
                edtma.setText(nv.getMaNV());
                edtten.setText(nv.getTenNV());

                //xử lý giới tính
                if (nv.getGioitinh().equals("Nam"))
                    rbtnNam.setChecked(true);
                else
                    rbtnNu.setChecked(true);
                //xử lý đơn vị
                for (int j = 0; j < listPB.length; j++) {
                    if (nv.getDonvi().equals(listPB[j])) {
                        spinner.setSelection(j);
                    }
                }
                imgHinh.setImageDrawable(nv.getD());
            }
        });
//        btnIMG.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                Intent i = new Intent(
//                        Intent.ACTION_PICK,
//                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(i, 99999);
//            }
//        });
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 99999 && resultCode == RESULT_OK && null != data) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = { MediaStore.Images.Media.DATA };
//            Cursor cursor = getContentResolver().query(selectedImage,
//                    filePathColumn, null, null, null);
//            cursor.moveToFirst();
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//
//            imgHinh.setImageBitmap(BitmapFactory.decodeFile(picturePath));
//            //add cai uri nay vao list uri roi set annh
//
//        }
//    }


        btnIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 999);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 999){
            imageUri = data.getData();
//            File f = new File(getRealPathFromURI(path));
        //    Drawable d = Drawable.createFromPath(f.getAbsolutePath());
            //myalyout.setBackground(d);

            Drawable d = UriToDrawable(imageUri);
            imgHinh.setImageDrawable(d);
        }
    }

    public Drawable UriToDrawable(Uri imageUri){
        File f = new File(getRealPathFromURI(imageUri));
        Drawable d = Drawable.createFromPath(f.getAbsolutePath());
        return d;
    }


    private String getRealPathFromURI(Uri contentURI) {
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }
}