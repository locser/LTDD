package com.example.listview_spinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChitietSP extends AppCompatActivity {

    TextView tvten, tvgia, tvloaisp, tvdungtich, tvthuonghieu,tvnoisx, tvttbs;
    ImageView imgSP;
    Button btnDatHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_sp);

        init();

        Bundle intent = getIntent().getExtras();

        String ten = intent.getString("ten");
        int gia = intent.getInt("gia", 0);
        String loaisp = intent.getString("loaisp");
        int dungtich = intent.getInt("dungtich", 0);
        String thuonghieu = intent.getString("thuonghieu");
        String noisx = intent.getString("noisx");
        int imsp= intent.getInt("img", 0);
        String ttbosung = intent.getString("ttbosung");

        SanPham sp = new SanPham(ten, gia, loaisp, dungtich, thuonghieu,noisx, imsp,ttbosung);

//        SanPham sp =(SanPham) getIntent().getParcelableExtra("sp");


        tvten.setText(sp.getTen());
        tvgia.setText(sp.getGia() + " đ");
        tvloaisp.setText(sp.getLoaisua());
        tvdungtich.setText(sp.getDungtich() + "ml");
        tvthuonghieu.setText(sp.getThuonghieu());
        tvnoisx.setText(sp.getNoisx());
        tvttbs.setText(sp.getTtbosung());
        imgSP.setImageResource(imsp);
//        imgSP.setImageResource(sp.getImgSP());
//        Toast.makeText(this, getResources().ge
//        tDrawable(img) + "", Toast.LENGTH_SHORT).show();
//            c1
//            int img= intent.getInt("img");
//            Log.e("getImgSP", String.valueOf(getResources().getDrawable(img)));
//            imgSP.setImageDrawable(getResources().getDrawable(img));
//            c2
//            byte[] byteArray = intent.getByteArray("img");
//            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//            imgSP.setImageResource(sp.getImgSP());
//        imgSP.setImageResource();
    }

    public void init(){
        tvten = findViewById(R.id.tvtensp);
        tvgia = findViewById(R.id.tvgia);
        tvloaisp = findViewById(R.id.tvloaisp);
        tvdungtich = findViewById(R.id.tvdungtich);
        tvthuonghieu   = findViewById(R.id.tvthuonghieu);
        tvnoisx = findViewById(R.id.tvnoisanxuat);
        tvttbs= findViewById(R.id.tvthongtinbosung);
        imgSP = findViewById(R.id.imageView);

    }
}