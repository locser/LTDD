package com.example.baicaov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChoiVoiMayActivity extends AppCompatActivity {

    ImageView imgBot, imgdaidien, imgBot1,imgBot2, imgBot3, imgPlayer1, imgPlayer2, imgPlayer3, imgTiSoBot, imgTiSoPlayer, la1,la2,la3,la4,la5,la6;
    TextView tvTiso, tvKqDuoi, tvKqTren, tvTime,tvThangThua, tvTenPlayer;
    Button btnChiaBai, btnDung;


    int manghinhbai[]={
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_voi_may);
        init();
    }

    public void init() {
        imgBot = findViewById(R.id.imgBot);
        la2 = findViewById(R.id.imgBot1);
        la4 = findViewById(R.id.imgBot2);
        la6 = findViewById(R.id.imgBot3);

        imgdaidien = findViewById(R.id.imgDaiDien);
        la1 = findViewById(R.id.imgPlayer1);
        la3 = findViewById(R.id.imgPlayer2);
        la5 = findViewById(R.id.imgPlayer3);

        imgTiSoBot = findViewById(R.id.imgTiSoBot);
        imgTiSoPlayer = findViewById(R.id.imgTiSoPlayer);

        tvTiso = findViewById(R.id.tvTiSo);
        tvKqDuoi = findViewById(R.id.tvKqPlayer);// TÍnh điểm cho người chơi dưới
        tvKqTren = findViewById(R.id.tvKqBot);// TÍnh điểm cho người chơi trên

        tvTime = findViewById(R.id.tvTime);
        tvThangThua = findViewById(R.id.tvThangThua);
        tvTenPlayer = findViewById(R.id.tvTen);

        btnChiaBai = findViewById(R.id.btnChiaBai);
        btnDung = findViewById(R.id.btnDung);

        Bundle b = getIntent().getExtras();
        String loai = b.getString("Loai");
        String ten = b.getString("ten");
        String time = b.getString("time");


//        Toast.makeText(ChoiVoiMayActivity.this, (loai + " /" + ten + " /" + time), Toast.LENGTH_SHORT).show();
        int[] tiso = {0, 0};

        switch (loai){
            case "PlayervBot":{
                tvTenPlayer.setText(ten);
                tvTime.setText("");

                //settiso
                tiso[0] =0;//tisoduoi
                tiso[1] = 0;//tisotren

                btnChiaBai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        vanmoi();
                        //lấy 6 lá random
                        int[] saula = lay6SoNgauNhien(0, 51);

                        //chia bài nè!
                        choibainao(saula, 3000, 500, tiso, "Player");
                    }
                });


            };break;

            case "BotvBot": {
                tvTenPlayer.setText("Bot");
                tvTime.setText("Time: " + time);
                imgTiSoPlayer.setImageResource(R.drawable.iccomputer);

                tiso[0] =0;//tisoduoi
                tiso[1] = 0;//tisotren

                //getTime()
                int thoigian = Integer.parseInt(time);

                btnChiaBai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CountDownTimer countDownTimer = new CountDownTimer(thoigian * 1000, 1500) {
                            @Override
                            public void onTick(long l) {
                                int[] saula = lay6SoNgauNhien(0, 51);
                                vanmoi();

                                //chia bài nè!
                                choibainao(saula, 1000, 150, tiso,"Bot");
                                tvTime.setText("Time: " + l/1000);
                            }

                            @Override
                            public void onFinish() {
                                if(tiso[0] < tiso[1])
                                    tvTime.setText("Bot đã thua");
                                if(tiso[0] == tiso[1])
                                    tvTime.setText("Hai Bot hòa nhau");
                                if(tiso[0] > tiso[1])
                                    tvTime.setText("Bot đã thắng");
                            }
                        };
                        countDownTimer.start();
                    }
                });
            }
        }

        //button dung thoat
        btnDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void choibainao(int[] saula, int msFuture, int countdown, int[] tiso, String loai){

        //Thời gian tổng, thời gian mỗi lần trừ
        CountDownTimer count = new CountDownTimer(msFuture, countdown) {
            @Override
            public void onTick(long l) {//l là số s còn lại

                btnChiaBai.setVisibility(View.GONE);
                tvThangThua.setVisibility(View.GONE);
                tvKqDuoi.setVisibility(View.GONE);
                tvKqTren.setVisibility(View.GONE);

                int i = (int) (l/countdown);
                latbai(i, saula);
            }

            @Override
            public void onFinish() {
                tvThangThua.setVisibility(View.VISIBLE);
                tvKqDuoi.setVisibility(View.VISIBLE);
                tvKqTren.setVisibility(View.VISIBLE);
                btnChiaBai.setVisibility(View.VISIBLE);
                //TÍnh tỉ số
                int kq = TinhKetQua(saula);

                if(loai.equals("Player")){
                    if (kq == 0) {
                        tvThangThua.setText("Hòa");
                        tiso[0]++;
                        tiso[1]++;
                    }
                    if (kq == -1) {
                        tvThangThua.setText("Bạn Thua Máy");
                        tiso[1]++;
                    }
                    if (kq == 1) {
                        tvThangThua.setText("Bạn đã thắng");
                        tiso[0]++;
                    }
                    String strTiSo = tiso[0] + " - "+ tiso[1];
                    tvTiso.setText(strTiSo);
                }else{
                    if (kq == 0) {
                        tvThangThua.setText("Hòa");
                        tiso[0]++;
                        tiso[1]++;
                    }
                    if (kq == -1) {
                        tvThangThua.setText("Bot đã Thua ");
                        tiso[1]++;
                    }
                    if (kq == 1) {
                        tvThangThua.setText("Bot đã thắng");
                        tiso[0]++;
                    }
                    String strTiSo = tiso[0] + " - "+ tiso[1];
                    tvTiso.setText(strTiSo);
                }




            }
        };

        count.start();
    }

    public int TinhKetQua(int[] saula){

        //setup bài cho 2 phe
        int[] baiduoi = {saula[0],saula[2],saula[4]};
        int[] baitren=  {saula[1],saula[3],saula[5]};

        //tính điểm
        int diembaiduoi = tinhKetQua(baiduoi);
        int diembaitren = tinhKetQua(baitren);

        //settext điểm
        tvKqDuoi.setText(diembaiduoi + " điểm");
        tvKqTren.setText(diembaitren + " điểm");

        //tính thắng thua 2 phe
        if (diembaiduoi == 0)
            tvKqDuoi.setText("Bù");
        if (diembaiduoi == 11)
            tvKqDuoi.setText("3 lá tây");

        if (diembaitren== 0)
            tvKqTren.setText("Bù");
        if (diembaitren == 11)
            tvKqTren.setText("3 lá tây");


        int kq = tinhThangThua(diembaiduoi, diembaitren);
        return kq;
    }

    public void latbai(int i, int[] saula){
        //3k/5 =6 không set
        //2k9/5 = 5, i =5 set vào 5
        // do i từ 5 ->1

        switch (i){
            case 0: {
                la1.setImageResource(manghinhbai[saula[i]]);
            };break;
            case 1: {
                la2.setImageResource(manghinhbai[saula[i]]);
            };break;

            case 2: {
                la3.setImageResource(manghinhbai[saula[i]]);
            };break;

            case 3: {
                la4.setImageResource(manghinhbai[saula[i]]);
            };break;

            case 4: {
                la5.setImageResource(manghinhbai[saula[i]]);
            };break;

            case 5: {
                la6.setImageResource(manghinhbai[saula[i]]);
            };break;
        };
    }

    private int[] lay6SoNgauNhien(int min, int max){
        int[] baso= new int[6];
        int i = 0;
        baso[i++] = random(min, max);
        do{
            int k= random(min, max);
            if(!kiemTraTrung(k, baso))
                baso[i++] = k;
        }while(i< 6);
        return baso;
    }

    public boolean kiemTraTrung(int k, int[] arr){
        for (int j : arr) {
            if (j == k)
                return true;
        }
        return false;
    }

    private int random(int min, int max){
        return min+ (int)(Math.random() * ((max-min) + 1));

    }

    private int tinhSoTay(int[]arr){
        int k = 0;
        for (int j : arr)
            if (j % 13 >= 10 && j > 10)
                k++;
        return k;
    }

    private int tinhKetQua(int[]arr){
        int kq= 0;
        if(tinhSoTay(arr)==3)
//            ketqua = "3 tây";
            kq= 11;
        else{
            int tong = 0;
            for (int j : arr)
                if (j % 13 < 10)
                    tong += j % 13 + 1;
            if(tong%10 == 0)
                //bù
                kq =0;
            else
                kq = (tong%10);
        }
        return kq;
    }

    public int tinhThangThua(int diembaiDuoi, int diembaiTren){
        if(diembaiDuoi > diembaiTren)
            return 1; // dưới thắng
        if(diembaiDuoi == diembaiTren)
            return 0; // Hòa
        return -1;// trên thắng
    }

    public void vanmoi(){
        la1.setImageResource(R.drawable.b1fv);
        la2.setImageResource(R.drawable.b1fv);
        la3.setImageResource(R.drawable.b1fv);
        la4.setImageResource(R.drawable.b1fv);
        la5.setImageResource(R.drawable.b1fv);
        la6.setImageResource(R.drawable.b1fv);
    }

}
/*
* Rac
* //        if(loai.equals("PlayervBot")){
//            tvTenPlayer.setText(ten);
//            tvTime.setText("");
//            imgTiSoPlayer.setImageResource(R.drawable.icperson);
//        }
//        if(loai.equals("BotvBot")){
//            tvTenPlayer.setText("Bot");
//            tvTime.setText("Time: " + time);
//            imgTiSoPlayer.setImageResource(R.drawable.iccomputer);
//        }
* */