package com.example.ui_demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Button btnIMG, btnthem, btnsua,btntruyvan, btnlammoi, btnghifile, btndocfile;
    EditText edtten, edtma;
    RadioButton rbtnNam, rbtnNu;
    Spinner spinner;
    ArrayList<NhanVien> listNV = new ArrayList<>();
    String[] listPB;
    String donvi;
    //duong dan anh
    Uri imageUri;
    ImageView imgHinh;
    List<Uri> listImageUri;
    String filename= "uidemo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        khaibao();

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
                String uri= nv.getImageUri();

                if (!(uri.equals("")))
                    imgHinh.setImageURI(Uri.parse(uri));
                else{
                    imgHinh.setImageResource(R.drawable.iconprivatepeople);
                }
            }
        });

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String maso = edtma.getText().toString();
                String ten = edtten.getText().toString();
                if((maso.length() >0) && (ten.length()>0) ){
                    String gioitinh = (rbtnNam.isChecked()) ? "Nam" : "Nữ";

                    String imguri ="" ;
//                    if(!(imageUri.toString().equals(""))){
//                        imguri= imageUri.toString();
//                    }
                    if (imageUri != null && !imageUri.equals(Uri.EMPTY)) {
                        //doTheThing()
                        imguri= imageUri+"";
                    } else {
                        //followUri is null or empty
                    }

                    NhanVien nv = new NhanVien(maso, ten, gioitinh, donvi, imguri );
                    listNV.add(nv);
                    adapterNV.notifyDataSetChanged();
                }else {
                    Toast.makeText(MainActivity.this, "Hãy Nhập đầy đủ thông tin của nhân viên", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =  new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("THông báo").setMessage("Bạn muốn sửa nhân viên này chứ?");
                builder.setPositiveButton("Sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String maso = edtma.getText().toString();
                        String ten = edtten.getText().toString();

                        if((maso.length() >0) && (ten.length()>0) ){
                            String gioitinh = (rbtnNam.isChecked()) ? "Nam" : "Nữ";

                            String imguri ="" ;
//                    if(!(imageUri.toString().equals(""))){
//                        imguri= imageUri.toString();
//                    }
                            if (imageUri != null && !imageUri.equals(Uri.EMPTY)) {
                                //doTheThing()
                                imguri= imageUri+"";
                            } else {
                                //followUri is null or empty
                            }
                            int j = timkiemNV(maso);
                            if(j>0){
                                listNV.get(j).setMaNV(maso);
                                listNV.get(j).setTenNV(ten);
                                listNV.get(j).setGioitinh(gioitinh);
                                listNV.get(j).setDonvi(donvi);
                                listNV.get(j).setImageUri(imguri);

                                adapterNV.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                            }


                        }else {
                            Toast.makeText(MainActivity.this, "Hãy Nhập đầy đủ thông tin của nhân viên", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                builder.create().show();
            }
        });


        btntruyvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<NhanVien>  lnv  = new ArrayList<>();

                String maso = edtma.getText().toString();
                String ten = edtten.getText().toString();

                if((maso.length() >0)){
                    for (int j = 0 ; j< listNV.size(); j++){
                        if(maso.equals(listNV.get(j).getMaNV()))
                            lnv.add(listNV.get(j));
                    }

                    if(lnv.size()>0){
                        Toast.makeText(MainActivity.this, "Tìm thấy nhân viên", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Không Tìm thấy nhân viên", Toast.LENGTH_SHORT).show();
                    }

                    customlistAdapter adapterNV = new customlistAdapter(MainActivity.this, lnv);
                    lv.setAdapter(adapterNV);
                }else{
                    if((ten.length() >0)){
                        for (int j = 0 ; j< listNV.size(); j++){
                            if(ten.equals(listNV.get(j).getTenNV()))
                                lnv.add(listNV.get(j));
                        }

                        if(lnv.size()>0){
                            Toast.makeText(MainActivity.this, "Tìm thấy nhân viên", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Không Tìm thấy nhân viên", Toast.LENGTH_SHORT).show();
                        }

                        customlistAdapter adapterNV = new customlistAdapter(MainActivity.this, lnv);
                        lv.setAdapter(adapterNV);
                    }else{
                        Toast.makeText(MainActivity.this, "Hãy nhập 1 hoặc 2 dữ liệu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnlammoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customlistAdapter adapterNV = new customlistAdapter(MainActivity.this, listNV);
                lv.setAdapter(adapterNV);
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


        /**
         *This loop is not correct. readObject() does not return null at end of stream. It can do that any time you wrote a null. At end of stream it throws EOFException. So:
         */
        btndocfile.setOnClickListener(new View.OnClickListener() {
            ArrayList<NhanVien> lnv = new ArrayList<>();
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fin = openFileInput(filename);
                    ObjectInputStream o = new ObjectInputStream(fin);

                    NhanVien n ;
                    for (;;) {
                        try {
                            n = (NhanVien) o.readObject();
                            lnv.add(n);
                        }
                        catch (EOFException exc) {
                            break;
                        }
                    }

                    Toast.makeText(MainActivity.this, "Đọc file hoàn tất!", Toast.LENGTH_SHORT).show();
                    listNV = lnv;
                    customlistAdapter adapterNV = new customlistAdapter(MainActivity.this, listNV);
                    lv.setAdapter(adapterNV);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Đọc file không thành công!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        btnghifile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fout = openFileOutput(filename, Context.MODE_PRIVATE);
                    ObjectOutputStream o = new ObjectOutputStream(fout);

                    for(NhanVien n : listNV){
                        o.writeObject(n);
                    }
                    o.close();
                    Toast.makeText(MainActivity.this, "Ghi thành công: " + getFilesDir(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Ghi xuống file không thành công!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });

        btnIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 999);
            }
        });

    }

    private void khaibao() {

        lv = findViewById(R.id.listview);
        imgHinh = findViewById(R.id.imgHinh);
        btnIMG = findViewById(R.id.btnImg);
        btnthem = findViewById(R.id.btnThem);
        btnlammoi = findViewById(R.id.btnLamMoi);
        btnghifile = findViewById(R.id.btnGhiFile);
        btndocfile = findViewById(R.id.btnDocFile);
        btnsua = findViewById(R.id.btnSua);
        btntruyvan = findViewById(R.id.btnTruyvan);
        edtten = findViewById(R.id.edtTen);
        edtma = findViewById(R.id.edtMa);
        rbtnNam = findViewById(R.id.rbtnNam);
        rbtnNu = findViewById(R.id.rbtnNu);
        spinner = findViewById(R.id.spinner);
    }


    public int timkiemNV(String maso){
        for(int i = 0; i<listNV.size(); i++){
            if(listNV.get(i).getMaNV().equals(maso))
                return i;
        }
        return -1;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 999){
            imageUri = data.getData();

//            File f = new File(getRealPathFromURI(path));
            //    Drawable d = Drawable.createFromPath(f.getAbsolutePath());
            //myalyout.setBackground(d);

            imgHinh.setImageURI(imageUri);
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == 999){
//            imageUri = data.getData();
////            File f = new File(getRealPathFromURI(path));
//        //    Drawable d = Drawable.createFromPath(f.getAbsolutePath());
//            //myalyout.setBackground(d);
//
//            Drawable d = UriToDrawable(imageUri);
//            imgHinh.setImageDrawable(d);
//        }
//    }

//    public Drawable UriToDrawable(Uri imageUri){
//        File f = new File(getRealPathFromURI(imageUri));
//        Drawable d = Drawable.createFromPath(f.getAbsolutePath());
//        return d;
//    }
//
//
//    private String getRealPathFromURI(Uri contentURI) {
//        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
//        if (cursor == null) { // Source is Dropbox or other similar local file path
//            return contentURI.getPath();
//        } else {
//            cursor.moveToFirst();
//            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
//            return cursor.getString(idx);
//        }
//    }
}