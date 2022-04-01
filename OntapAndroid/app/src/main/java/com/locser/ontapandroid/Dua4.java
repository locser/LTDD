package com.locser.ontapandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Dua4 extends AppCompatActivity {
    CheckBox cbx1,cbx2,cbx3, cbx4;
    Button btnThoat, btnChoi;
    TextView tvkq, tvDiem;
    SeekBar seekBar1, seekBar2, seekBar3, seekBar4;

    int diem, thoigian1,thoigian2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua4);
        diem=20;
        //ánh xạ
        cbx1 =  findViewById(R.id.ccheckBox1);
        cbx2 =  findViewById(R.id.ccheckBox2);
        cbx3 = findViewById(R.id.ccheckBox3);
        cbx4 = findViewById(R.id.ccheckBox4);
        btnChoi =  findViewById(R.id.cbtnChoi);
        btnThoat =  findViewById(R.id.cbtnThoat);

        tvkq =  findViewById(R.id.ctvketqua);
        tvDiem =  findViewById(R.id.cbtvDiem);
        seekBar1 =  findViewById(R.id.cseekBar1);
        seekBar2 =  findViewById(R.id.cseekBar2);
        seekBar3 =  findViewById(R.id.cseekBar3);
        seekBar4 =  findViewById(R.id.cseekBar4);


        //set Điểm số khởi đầu cho người chơi
        tvDiem.setText("Điểm:" + diem);

        //set độ dài seekbar
        seekBar1.setMax(100);
        seekBar2.setMax(100);
        seekBar3.setMax(100);
        seekBar4.setMax(100);
        //reset đường đua
        setSeekbar();

        //setup time cho đường đua
//        tham số đầu là chạy trong bao lâu, tham số 2 mỗi lần giảm bao nhiêu.
        CountDownTimer count = new CountDownTimer(5000, 200) {
            Random rand = new Random();
            //xem người chơi chọn đường đua nào

            @Override
            public void onTick(long l) {
//                TODO con khi chạy
                //mỗi 500 mls , + 5, để kết quả luôn lớn hơn 5, cộng vào thanh seekbar.
                int r1=  rand.nextInt(10) ;
                int r2=  rand.nextInt(10) ;
                int r3=  rand.nextInt(10) ;
                int r4=  rand.nextInt(10) ;

                //bắt đàu chạy, không cho chọn lại checkbox đường đua, setEnable
                cbx1.setEnabled(false);
                cbx2.setEnabled(false);
                cbx3.setEnabled(false);
                cbx4.setEnabled(false);

//        câp nhật hành trình hco seekbar
                seekBar1.setProgress(seekBar1.getProgress() + r1);
                seekBar2.setProgress(seekBar2.getProgress() + r2);
                seekBar3.setProgress(seekBar2.getProgress() + r3);
                seekBar4.setProgress(seekBar2.getProgress() + r4);

//                process == 20 là đã đi hết chặng, thắng
                if(seekBar1.getProgress() ==100){
//                    đường đua 1 win
                    this.cancel();   //Dừng lại do đã có người về đích
                    tvkq.setText("Đường đua 1 thắng");
                    //xem người chơi chọn đường đua nào
                    if((cbx1.isChecked() == true)){
                        Toast.makeText(Dua4.this, "Bạn đã thắng", Toast.LENGTH_SHORT).show();
                        diem+=10; //cộng điểm cho người chơi
                    }else{
                        Toast.makeText(Dua4.this, "Bạn đã thua", Toast.LENGTH_SHORT).show();
                        diem-=5;//trừ điểm cho người chơi
                    }
                    setcheckbox();
                }else{
                    if(seekBar2.getProgress() ==100){
//                    đường đua 1 win
                        this.cancel();   //Dừng lại do đã có người về đích
                        tvkq.setText("Đường đua 2 thắng");
                        //xem người chơi chọn đường đua nào
                        if((cbx2.isChecked() == true)){
                            diem+=10; //cộng điểm cho người chơi
                            Toast.makeText(Dua4.this, "Bạn đã thắng", Toast.LENGTH_SHORT).show();
                        }else{
                            diem-=5;//trừ điểm cho người chơi
                            Toast.makeText(Dua4.this, "Bạn đã thua", Toast.LENGTH_SHORT).show();

                        }
                        setcheckbox();
                    }else {
                        if (seekBar3.getProgress() == 100) {
//                    đường đua 3 win
                            this.cancel();   //Dừng lại do đã có người về đích
                            tvkq.setText("Đường đua 3 thắng");
                            //xem người chơi chọn đường đua nào
                            if ((cbx3.isChecked() == true)) {
                                diem += 10; //cộng điểm cho người chơi
                                Toast.makeText(Dua4.this, "Bạn đã thắng", Toast.LENGTH_SHORT).show();
                            } else {
                                diem -= 5;//trừ điểm cho người chơi
                                Toast.makeText(Dua4.this, "Bạn đã thua", Toast.LENGTH_SHORT).show();

                            }
                            setcheckbox();
                        }else {
                            if (seekBar4.getProgress() == 100) {
//                    đường đua 3 win
                                this.cancel();   //Dừng lại do đã có người về đích
                                tvkq.setText("Đường đua 4 thắng");
                                //xem người chơi chọn đường đua nào
                                if ((cbx4.isChecked() == true)) {
                                    diem += 10; //cộng điểm cho người chơi
                                    Toast.makeText(Dua4.this, "Bạn đã thắng", Toast.LENGTH_SHORT).show();
                                } else {
                                    diem -= 5;//trừ điểm cho người chơi
                                    Toast.makeText(Dua4.this, "Bạn đã thua", Toast.LENGTH_SHORT).show();

                                }
                                setcheckbox();
                            }
                        }
                    }
                }
            }

            @Override
            public void onFinish() {
                //dừng chạy
//                cho phép ấn lại checkbox đường đua

            }
        };


        // Chơi = nhấn nút bắt đầu
        btnChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TODO:  chưa kiểm tra điểm người chơi còn hay không

                if(diem<= 0){
                    Toast.makeText(Dua4.this, "Bạn đã hết điểm", Toast.LENGTH_SHORT).show();
                }else{
                    //Xác nhận xem người chơi đã chọn đường đua hay chưă. đã chọn 1 trong số các checkbox của đường đua chưa

                    //tại màn chế độ 2 người chơi, chỉ có 2 đường đua seekbar 1 và 2 tương ứng 2 cbx 1 và 2.
//                xét trường hợp nếu cả 2 không được chọn, nghĩa là chưa chọn bất cứ  1 đường đua nào
                    if((cbx1.isChecked() == false) &&(cbx2.isChecked() == false) &&(cbx3.isChecked() == false)&&(cbx4.isChecked() == false)){
                        Toast.makeText(Dua4.this, "Hãy chọn 1 đường đua để bắt đầu", Toast.LENGTH_SHORT).show();
                    }else{
                        // nếu đã chọn, chỉ được chọn 1,
                        //Trường hợp cả 2 được chọn
                        if((cbx1.isChecked() == true) &&(cbx2.isChecked() == true) &&(cbx3.isChecked() == true) &&(cbx4.isChecked() == true) ){
                            Toast.makeText(Dua4.this, "Chỉ được chọn 1 đường đua", Toast.LENGTH_SHORT).show();
                        }else{
//                        TODO: xử lý chơi

                            //reset đường đua
                            setSeekbar();
//                        bắt đầu đua

                            count.start();

                            // sau đua cập nhật lại điểm cho người chơi
                            tvDiem.setText("Điểm: " + diem);
                        }
                    }
                }

            }
        });

        //quay lại menu màn hình Chế độ chơi
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                THoát màn hình hiện tại về màn cũ, nếu là màn ban đầu thì sẽ out ứng dụng
                finish();
            }
        });
    }

    public void setSeekbar(){
//        đưua seekbar về vị trí ban đầu, reset đường đua
        seekBar1.setProgress(0);
        seekBar2.setProgress(0);
        seekBar3.setProgress(0);
        seekBar4.setProgress(0);
        thoigian1=0;
        thoigian2=0;
    }

    public void setcheckbox(){
        cbx1.setEnabled(true);
        cbx2.setEnabled(true);
        cbx3.setEnabled(true);
        cbx4.setEnabled(true);
        // sau đua cập nhật lại điểm cho người chơi
        tvDiem.setText("Điểm: " + diem);
    }

}